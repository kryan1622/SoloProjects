package com.qa.persistence.repository;

public interface MembersRepository {

	public String createMember(String Members);
	public String getAllMembers();
	public String findMember(int memberid);
	public String updateMember(int memberid, String Member);
	public String deleteMember(int memberid);
}
