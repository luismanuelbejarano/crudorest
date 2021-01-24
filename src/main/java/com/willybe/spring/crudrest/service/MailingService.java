package com.willybe.spring.crudrest.service;

import java.util.List;

import com.willybe.spring.crudrest.entity.Mailing;

public interface MailingService {

	public List<Mailing> findAll();
	
	public Mailing findById(int theId);
	
	public void save(Mailing theMailing);
	
	public void deleteById(int theId);
	
}
