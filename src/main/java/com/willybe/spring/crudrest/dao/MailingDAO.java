package com.willybe.spring.crudrest.dao;

import java.util.List;

import com.willybe.spring.crudrest.entity.Mailing;

public interface MailingDAO {

	public List<Mailing> findAll();
	
	public Mailing findById(int theId);
	
	public void save(Mailing theMailing);
	
	public void deleteById(int theId);
	
}
