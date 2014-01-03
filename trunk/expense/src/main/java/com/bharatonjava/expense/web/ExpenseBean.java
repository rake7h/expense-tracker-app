package com.bharatonjava.expense.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;

import com.bharatonjava.expense.domain.Entry;
import com.bharatonjava.expense.domain.Group;
import com.bharatonjava.expense.service.ExpenseService;
import com.bharatonjava.expense.util.Constants;

public class ExpenseBean implements Serializable{

	private static final long serialVersionUID = 3911154823819359744L;

	private Entry entry;
	
	private List<Entry> entries;
	
	private List<String> groupNames;
	private String selectedGroup;
	private List<Group> groups;
	
	private ExpenseService expenseService;
	
	public void setExpenseService(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	public ExpenseBean() {
		entry = new Entry();
		entry.setEntryDate(new Date());
		groupNames = new ArrayList<String>();
		groupNames.add(Constants.EXPENSE);
		groupNames.add(Constants.INCOME);
		
		selectedGroup = Constants.EXPENSE;
		
		
	}
	
	@PostConstruct
	public void initialize(){
		groups = expenseService.getGroups(selectedGroup);
		entries = expenseService.getExpenses();
	}
	
	public List<Entry> getEntries() {
		return entries;
	}
	
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	
	public Entry getEntry() {
		return entry;
	}
	
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	
	public List<String> getGroupNames() {
		return groupNames;
	}
	
	public String getSelectedGroup() {
		return selectedGroup;
	}
	
	public List<Group> getGroups() {
		return groups;
	}
	
	
	public void setSelectedGroup(String selectedGroup) {
		this.selectedGroup = selectedGroup;
	}
	
	public void getExpenses(){
		entries = expenseService.getExpenses();
		System.out.println("entries" + entries.size());
	}
	
	public void typeChangeListener(AjaxBehaviorEvent ajaxBehaviorEvent){
		groups = expenseService.getGroups(selectedGroup);
		System.out.println("type changed." + selectedGroup);
	}
	
	public void saveEntry(){
		System.out.println("entry - "+ entry);
		expenseService.saveEntry(entry);
		entries = expenseService.getExpenses();
	}
	
}
