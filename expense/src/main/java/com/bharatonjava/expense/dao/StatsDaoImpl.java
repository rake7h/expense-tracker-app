package com.bharatonjava.expense.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bharatonjava.expense.dao.mapper.MonthDtoRowMapper;
import com.bharatonjava.expense.dao.mapper.StatRowMapper;
import com.bharatonjava.expense.dao.mapper.YearRowMapper;
import com.bharatonjava.expense.domain.MonthDto;
import com.bharatonjava.expense.domain.Stat;

@Repository
public class StatsDaoImpl implements StatsDao {

	private static final Log log = LogFactory.getLog(StatsDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Integer> getYears() {

		List<Integer> years = null;
		String sql = "select DISTINCT EXTRACT(YEAR FROM E.ENTRY_DATE) AS YEAR FROM ENTRIES E";
		years = this.jdbcTemplate.query(sql, new YearRowMapper());
		return years;
	}

	@Override
	public List<MonthDto> getMonths(Integer year) {
		List<MonthDto> months = null;
		String sql = "select DISTINCT  MONTHNAME(STR_TO_DATE(EXTRACT(MONTH FROM E.ENTRY_DATE), '%m')) AS MONTH_STRING,"
				+ " EXTRACT(MONTH FROM E.ENTRY_DATE) AS MONTH FROM ENTRIES E "
				+ " WHERE EXTRACT(YEAR FROM E.ENTRY_DATE) = ?";
		months = this.jdbcTemplate.query(sql, new MonthDtoRowMapper(),
				new Object[] { year });
		return months;
	}

	@Override
	public List<Stat> getStats(Integer year, Integer month) {
		log.info("year: " + year + " ,month: " + month);
		List<Stat> stats = null;
		String sql = "select sum(e.amount) as total,g.group_value as item"
				+ " from entries e join groups g on e.group_id=g.group_id"
				+ " where g.group_name like 'EXPENSE'"
				+ " AND extract( month from entry_date) = ?"
				+ " AND EXTRACT(YEAR FROM ENTRY_DATE) >= ?"
				+ " group by g.group_value";
		stats = this.jdbcTemplate.query(sql, new StatRowMapper(), new Object[] {
				month, year });
		return stats;
	}
}
