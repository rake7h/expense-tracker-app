package com.bharatonjava.expense.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.expense.domain.Stat;

public class StatRowMapper implements RowMapper<Stat>{

	@Override
	public Stat mapRow(ResultSet rs, int rowNum) throws SQLException {
		Stat s = new Stat();
		s.setItem(rs.getString("ITEM"));
		s.setTotal(rs.getDouble("TOTAL"));
		return s;
	}

}
