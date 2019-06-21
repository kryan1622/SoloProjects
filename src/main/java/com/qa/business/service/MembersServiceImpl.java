package com.qa.business.service;
import javax.inject.Inject;
import com.qa.persistence.repository.MembersRepository;

public class MembersServiceImpl implements MembersService{
	
	@Inject
	private MembersRepository mr;

	@Override
	public String getAllMembers() {
		return mr.getAllMembers();
	}


	@Override
	public String findMember(int memberid) {
		return mr.findMember(memberid);
	}

	@Override
	public String deleteMember(int memberid) {
		return mr.deleteMember(memberid);
	}

	@Override
	public String updateMember(int memberid, String member) {
		return mr.updateMember(memberid, member);
	}

	@Override
	public String createMember(String member) {
		return mr.createMember(member);
	}
	

}
