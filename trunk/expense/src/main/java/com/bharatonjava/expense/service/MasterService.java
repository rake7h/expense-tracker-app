package com.bharatonjava.expense.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.expense.dao.MasterDao;
import com.bharatonjava.expense.domain.Group;

public class MasterService {
	
	private MasterDao masterDao;
	
	public void setMasterDao(MasterDao masterDao) {
		this.masterDao = masterDao;
	}

	@Transactional
	public List<Group> getAllGroups(){
		return masterDao.getAllGroups();
	}
}
