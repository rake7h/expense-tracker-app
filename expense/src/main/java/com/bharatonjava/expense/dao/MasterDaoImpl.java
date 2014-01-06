package com.bharatonjava.expense.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bharatonjava.expense.dao.mapper.GroupRowMapper;
import com.bharatonjava.expense.domain.Group;

public class MasterDaoImpl implements MasterDao{

	private static final Log log = LogFactory.getLog(MasterDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Group> getAllGroups(){
		List<Group> groups = null;
		String sql = "SELECT * FROM GROUPS ORDER BY GROUP_NAME, GROUP_VALUE";
		groups = this.jdbcTemplate.query(sql, new GroupRowMapper());
		return groups;
	}
	
}
