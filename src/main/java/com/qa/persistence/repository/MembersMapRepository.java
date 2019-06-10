package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Members;
import com.qa.util.JSONUtil;

public class MembersMapRepository implements MembersRepository{

	private Map<Integer,Members> membersMap = new HashMap<Integer,Members>();
	JSONUtil j1 = new JSONUtil();
	
	public Map<Integer, Members> getmembersMap(){
		return membersMap;
	}
	public String createMember(String Members) {
		Members m1 = j1.getObjectForJSON(Members, Members.class);
		membersMap.put(m1.getMemberid(), m1);
			return "Member successfully created";	
		}
	
	public String getAllMembers() {
		return j1.getJSONForObject(membersMap.values());
	}
	
	public String findMember(int memberid) {
		return j1.getJSONForObject(membersMap.get(memberid));
	}
	
	
	public String updateMember(int memberid, String Member) {
		Members m2 = j1.getObjectForJSON(Member, Members.class);

		if (membersMap.containsKey(memberid)) {
			membersMap.replace(memberid, m2);
			return "Member updated" + j1.getJSONForObject(membersMap.get(memberid));
		}

		return "Member failed to update";
	}
	
	public String deleteMember(int memberid) {
		membersMap.remove(memberid);
		return "Member successfully deleted" + j1.getJSONForObject(membersMap.get(memberid));
	}
}
