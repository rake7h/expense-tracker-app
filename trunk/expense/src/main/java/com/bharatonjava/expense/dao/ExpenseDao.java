package com.bharatonjava.expense.dao;

import java.util.List;

import com.bharatonjava.expense.domain.Entry;
import com.bharatonjava.expense.domain.Group;

public interface ExpenseDao {

	public List<Entry> getEntries(String type);

	public List<Group> getGroups(String type);

	public Group getGroupByValue(String groupValue);
	
	public int saveEntry(Entry entry);
}
