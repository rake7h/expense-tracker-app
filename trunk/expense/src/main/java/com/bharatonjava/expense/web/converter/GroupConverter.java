package com.bharatonjava.expense.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.bharatonjava.expense.domain.Group;
import com.bharatonjava.expense.service.ExpenseService;
import com.bharatonjava.expense.util.ContextUtil;

public class GroupConverter implements Converter{

	private static final Log log = LogFactory.getLog(GroupConverter.class);
	private ApplicationContext applicationContext;
	
	public GroupConverter() {
		applicationContext = ContextUtil.getApplicationContext();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value == null)
		{
			throw new IllegalArgumentException();
		}
		
		ExpenseService expenseService = (ExpenseService) applicationContext.getBean("expenseService");
		Group group = expenseService.getGroupByValue(value);
		
		return group;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		ExpenseService expenseService = (ExpenseService) applicationContext.getBean("expenseService");
		Group group = (Group) value;
		return String.valueOf(group.getGroupId());
	}

}
