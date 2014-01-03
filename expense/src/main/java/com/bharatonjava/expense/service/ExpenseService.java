package com.bharatonjava.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.expense.dao.ExpenseDao;
import com.bharatonjava.expense.domain.Entry;
import com.bharatonjava.expense.domain.Group;
import com.bharatonjava.expense.util.Constants;

@Service
public class ExpenseService {

	private ExpenseDao expenseDao;

	public void setExpenseDao(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}

	@Transactional
	public List<Entry> getExpenses() {
		List<Entry> entries = expenseDao.getEntries(Constants.EXPENSE);
		return entries;
	}

	@Transactional
	public List<Group> getGroups(String type) {
		return expenseDao.getGroups(type);
	}

	@Transactional
	public Group getGroupByValue(String value) {
		return expenseDao.getGroupByValue(value);
				
	}
	
	@Transactional
	public int saveEntry(Entry entry){
		return expenseDao.saveEntry(entry);
	}
}
