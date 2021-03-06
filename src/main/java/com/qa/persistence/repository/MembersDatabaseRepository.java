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
import java.util.Collection;

@Transactional(SUPPORTS)
@Default
public class MembersDatabaseRepository implements MembersRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil j1;

	@Override
	@Transactional(REQUIRED)
	public String createMember(String member) {
		Members amember = j1.getObjectForJSON(member, Members.class);
		manager.persist(amember);
		return "{\"message\": \"Member has been successfully added\"}";
	}

	@Override
	public String getAllMembers() {
		Query query = manager.createQuery("SELECT m FROM Members m");
		Collection<Members> members = (Collection<Members>) query.getResultList();

		if (members.isEmpty()) {
			return "{\"message\": \"No members found\"}";
		}

		else {

			return j1.getJSONForObject(query.getResultList());
		}
	}

	@Override
	public String findMember(int memberid) {
		return j1.getJSONForObject(manager.find(Members.class, memberid));
	}

	@Override
	@Transactional(REQUIRED)
	public String updateMember(int memberid, String member) {

		Members oldaccount = manager.find(Members.class, memberid);
		Members newaccount = j1.getObjectForJSON(member, Members.class);

		if (oldaccount != null) {
			oldaccount.setFirstname(newaccount.getFirstname());
			oldaccount.setLastname(newaccount.getLastname());
			manager.persist(oldaccount);
			return "{\"message\": \"Member successfully updated\"}";
		} else {
			return "{\"message\": \"No member found with this id\"}";
		}
	}

	@Transactional(REQUIRED)
	public String deleteMember(int memberid) {
		Members member = manager.find(Members.class, memberid);

		if (manager.contains(member)) {
			manager.remove(member);
			return "{\"message\": \"Member sucessfully deleted " + memberid + " \"}";
		} else {
			return "{\"message\": \"No member found with this id\"}";
		}
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getJ1() {
		return j1;
	}

	public void setJ1(JSONUtil j1) {
		this.j1 = j1;
	}

}
