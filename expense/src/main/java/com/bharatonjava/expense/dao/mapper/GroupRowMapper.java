package com.bharatonjava.expense.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.expense.domain.Group;

public class GroupRowMapper implements RowMapper<Group> {

	@Override
	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Group g = new Group();
		
		g.setGroupId(rs.getInt("GROUP_ID"));
		g.setGroupName(rs.getString("GROUP_NAME"));
		g.setGroupValue(rs.getString("GROUP_VALUE"));
		g.setEnabled(rs.getString("ENABLED"));
		return g;
	}

}
