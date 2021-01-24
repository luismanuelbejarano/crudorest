package com.willybe.spring.crudrest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.willybe.spring.crudrest.entity.Mailing;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MailingDAOHibernateImpl implements MailingDAO {

	// define field for entitymanager (injection)
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public MailingDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Mailing> findAll() {

		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create query
		Query<Mailing> theQuery =
				currentSession.createQuery("from Mailing", Mailing.class);
		
		// execute query and get result list
		List<Mailing> mailings = theQuery.getResultList();
		
		// return results
		return mailings;
	}


	@Override
	public Mailing findById(int theId) {

		// get  current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get subscriber
		Mailing theMailing =
				currentSession.get(Mailing.class, theId);
		
		// return
		return theMailing;
	}


	@Override
	public void save(Mailing theMailing) {

		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save
		currentSession.saveOrUpdate(theMailing);
	}


	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object
		Query theQuery = 
				currentSession.createQuery(
						"delete from Mailing where id=:subscriberId");
		theQuery.setParameter("subscriberId", theId);
		
		theQuery.executeUpdate();
	}

}







