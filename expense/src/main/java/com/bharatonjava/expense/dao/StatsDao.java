package com.bharatonjava.expense.dao;

import java.util.List;

import com.bharatonjava.expense.domain.MonthDto;
import com.bharatonjava.expense.domain.Stat;

public interface StatsDao {

	public List<Integer> getYears();
	
	public List<MonthDto> getMonths(Integer year);
	
	public List<Stat> getStats(Integer year, Integer month);
	
}
