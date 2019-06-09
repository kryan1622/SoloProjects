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
}
