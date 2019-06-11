package com.qa.persistence.repository;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.enterprise.inject.Default;
import com.qa.persistence.domain.Members;
import com.qa.util.JSONUtil;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class MembersDatabaseRepository implements MembersRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil j1;

	@Override
	public String createMember(String Members) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(SUPPORTS)
	public String getAllMembers() {
		Query query =  manager.createQuery("SELECT m FROM Members m");
		return j1.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(SUPPORTS)
	public String findMember(int memberid) {
		return j1.getJSONForObject(manager.find(Members.class, memberid));
	}

	@Override
	public String updateMember(int memberid, String Member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMember(int memberid) {
		// TODO Auto-generated method stub
		return null;
	}

}
