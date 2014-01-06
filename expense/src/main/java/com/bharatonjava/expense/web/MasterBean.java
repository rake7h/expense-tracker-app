package com.bharatonjava.expense.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;

import com.bharatonjava.expense.domain.Group;
import com.bharatonjava.expense.service.MasterService;

public class MasterBean implements Serializable{

	private static final long serialVersionUID = 874771869277206617L;
	private MasterService masterService;
	private List<Group> groups;
	
	public MasterBean() {
	
	}
	
	@PostConstruct
	public void initialize(){
		groups = masterService.getAllGroups();
	}
		
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	public List<Group> getGroups() {
		return groups;
	}
	
	
	public void onEdit(RowEditEvent event){
		
	}

	public void onCancel(RowEditEvent event){
		
	}
	
	
}
