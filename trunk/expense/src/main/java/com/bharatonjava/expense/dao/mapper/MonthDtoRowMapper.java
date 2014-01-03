package com.bharatonjava.expense.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.expense.domain.MonthDto;

public class MonthDtoRowMapper implements RowMapper<MonthDto>{

	@Override
	public MonthDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MonthDto m= new MonthDto();
		m.setMonth(rs.getInt("MONTH"));
		m.setMonthString(rs.getString("MONTH_STRING"));
		return m;
	}

}
