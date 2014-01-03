package com.bharatonjava.expense.web.converter;

import java.text.DateFormatSymbols;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bharatonjava.expense.domain.MonthDto;

public class MonthDtoConverter implements Converter {

	private static final Log log = LogFactory.getLog(MonthDtoConverter.class);

	public MonthDtoConverter() {
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		//log.info("------ " + value);
		int monthInt = Integer.parseInt(value);
		String monthString = new DateFormatSymbols().getMonths()[monthInt - 1];
		
		MonthDto monthDto = new MonthDto();
		monthDto.setMonth(monthInt);
		monthDto.setMonthString(monthString);
		
		return monthDto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		//log.info("------ " + object);
		MonthDto monthDto = (MonthDto) object;
		return String.valueOf(monthDto.getMonth());
	}

}
