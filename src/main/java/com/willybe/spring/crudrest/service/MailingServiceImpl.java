package com.willybe.spring.crudrest.service;

import java.util.List;

import com.willybe.spring.crudrest.entity.Mailing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.willybe.spring.crudrest.dao.MailingDAO;

@Service
public class MailingServiceImpl implements MailingService {

	private MailingDAO mailingDAO;
	
	@Autowired
	public MailingServiceImpl(MailingDAO theMailingDAO) {
		mailingDAO = theMailingDAO;
	}
	
	@Override
	@Transactional
	public List<Mailing> findAll() {
		return mailingDAO.findAll();
	}

	@Override
	@Transactional
	public Mailing findById(int theId) {
		return mailingDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Mailing theMailing) {
		mailingDAO.save(theMailing);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		mailingDAO.deleteById(theId);
	}

}






