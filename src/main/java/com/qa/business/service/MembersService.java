package com.qa.business.service;

public interface MembersService{
	String getAllMembers();
	String findMember(int memberid);
	String deleteMember(int memberid);
	String updateMember(int memberid, String member);
	String createMember(String member);
	String findMemberbyName(String firstname);
}
