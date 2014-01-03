package com.bharatonjava.expense.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.expense.domain.Entry;
import com.bharatonjava.expense.domain.Group;

public class EntryRowMapper implements RowMapper<Entry> {

	@Override
	public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Entry e = new Entry();
		Group g = new Group();
		
		g.setGroupId(rs.getInt("GROUP_ID"));
		g.setGroupName(rs.getString("GROUP_NAME"));
		g.setGroupValue(rs.getString("GROUP_VALUE"));

		e.setEntryId(rs.getInt("ENTRY_ID"));
		e.setEntryDate(rs.getDate("ENTRY_DATE"));
		e.setEntryDetail(rs.getString("ENTRY_DETAIL"));
		e.setAmount(rs.getDouble("AMOUNT"));
		
		e.setGroup(g);
		return e;
	}

}
