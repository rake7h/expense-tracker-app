package com.bharatonjava.expense.web;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.bharatonjava.expense.domain.MonthDto;
import com.bharatonjava.expense.domain.Stat;
import com.bharatonjava.expense.service.StatsService;

public class StatsBean implements Serializable {

	private static final long serialVersionUID = -7046627210399794766L;

	private StatsService statsService;

	private List<Integer> years;
	private Integer selectedYear;

	private List<MonthDto> months;
	private MonthDto selectedMonth;

	// for graph
	private CartesianChartModel statsChartModel;

	private List<Stat> stats;

	public StatsBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initialize() {
		// initialize year
		years = statsService.getYears();
		selectedYear = Calendar.getInstance().get(Calendar.YEAR);
		
		// initialize month
		months = statsService.getMonths(selectedYear);
		
		int monthInt = Calendar.getInstance().get(Calendar.MONTH);
		monthInt = monthInt + 1;
		String monthString = new DateFormatSymbols().getMonths()[monthInt - 1];
		MonthDto monthDto = new MonthDto();
		monthDto.setMonth(monthInt);
		monthDto.setMonthString(monthString);
		selectedMonth = monthDto;
		
		// get stats for selected month and year
		stats = statsService.getStats(selectedYear, selectedMonth.getMonth());
	}

	public void setStatsService(StatsService statsService) {
		this.statsService = statsService;
	}

	public List<Integer> getYears() {
		return years;
	}

	public List<MonthDto> getMonths() {
		return months;
	}

	public void setSelectedMonth(MonthDto selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public void setSelectedYear(Integer selectedYear) {
		this.selectedYear = selectedYear;
	}

	public void yearChangeListener(AjaxBehaviorEvent event) {
		System.out.println("yearChangeListener method called");
		months = statsService.getMonths(selectedYear);
	}

	public Integer getSelectedYear() {
		return selectedYear;
	}

	public MonthDto getSelectedMonth() {
		return selectedMonth;
	}

	public List<Stat> getStats() {
		return stats;
	}

	public CartesianChartModel getStatsChartModel() {
		return statsChartModel;
	}

	public void updateStatsTable() {
		System.out.println("updateStatsTable method called" );
		stats = statsService.getStats(selectedYear, selectedMonth.getMonth());
		getStatsSummary();
	}

	public double getStatsSummary() {
		System.out.println("getStatsSummary");
		Double aggrgate = 0.0;

		if (stats != null) {
			for (Stat s : stats) {
				aggrgate = aggrgate + s.getTotal();
			}
		}
		createCategoryModel();
		return aggrgate;
	}

	private void createCategoryModel() {
		statsChartModel = new CartesianChartModel();

		ChartSeries data = new ChartSeries();
		data.setLabel("Expense Stats");
		if (stats != null) {
			for (Stat s : stats) {
				data.set(s.getItem(), s.getTotal());
			}
		}
		statsChartModel.addSeries(data);
	}
}
