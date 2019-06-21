package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Members;
import com.qa.util.JSONUtil;

@Alternative
public class MembersMapRepository implements MembersRepository{

	private Map<Integer,Members> membersMap = new HashMap<>();
	JSONUtil j1 = new JSONUtil();
	
	public Map<Integer, Members> getmembersMap(){
		return membersMap;
	}
	public String createMember(String members) {
		Members m1 = j1.getObjectForJSON(members, Members.class);
		membersMap.put(m1.getMemberid(), m1);
			return "Member successfully created";	
		}
	
	public String getAllMembers() {
		return j1.getJSONForObject(membersMap.values());
	}
	
	public String findMember(int memberid) {
		return j1.getJSONForObject(membersMap.get(memberid));
	}
	
	
	public String updateMember(int memberid, String member) {
		Members m2 = j1.getObjectForJSON(member, Members.class);

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
