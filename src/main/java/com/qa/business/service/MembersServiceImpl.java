package com.qa.business.service;
import javax.inject.Inject;
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

}
