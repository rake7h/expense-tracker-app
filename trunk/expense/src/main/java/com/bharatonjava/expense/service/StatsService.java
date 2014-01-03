package com.bharatonjava.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.expense.dao.StatsDao;
import com.bharatonjava.expense.domain.MonthDto;
import com.bharatonjava.expense.domain.Stat;

@Service
public class StatsService {

	private StatsDao statsDao;
	
	public void setStatsDao(StatsDao statsDao) {
		this.statsDao = statsDao;
	}
	
	@Transactional
	public List<Integer> getYears(){
		return statsDao.getYears();
	}
	
	@Transactional
	public List<MonthDto> getMonths(Integer year){
		return statsDao.getMonths(year);
	}
	
	@Transactional
	public List<Stat> getStats(Integer year, Integer month){
		return statsDao.getStats(year, month);
	}
}
