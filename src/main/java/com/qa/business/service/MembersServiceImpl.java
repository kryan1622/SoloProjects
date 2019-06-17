package com.qa.business.service;
import javax.inject.Inject;
import javax.persistence.Query;

import com.qa.persistence.repository.MembersRepository;

public class MembersServiceImpl implements MembersService{
	
	@Inject
	private MembersRepository MR;

	@Override
	public String getAllMembers() {
		return MR.getAllMembers();
	}


	@Override
	public String findMember(int memberid) {
		return MR.findMember(memberid);
	}

	@Override
	public String deleteMember(int memberid) {
		return MR.deleteMember(memberid);
	}

	@Override
	public String updateMember(int memberid, String member) {
		return MR.updateMember(memberid, member);
	}

	@Override
	public String createMember(String member) {
		return MR.createMember(member);
	}


	@Override
	public String findMemberbyName(String firstname) {
		return MR.findMemberbyName(firstname);
	}
	

}
