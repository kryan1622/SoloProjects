package com.qa.persistence.repository;

public interface MembersRepository {

	public String createMember(String members);
	public String getAllMembers();
	public String findMember(int memberid);
	public String updateMember(int memberid, String member);
	public String deleteMember(int memberid);
}
