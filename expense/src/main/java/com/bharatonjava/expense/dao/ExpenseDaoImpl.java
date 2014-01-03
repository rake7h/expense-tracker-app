package com.bharatonjava.expense.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bharatonjava.expense.dao.mapper.EntryRowMapper;
import com.bharatonjava.expense.dao.mapper.GroupRowMapper;
import com.bharatonjava.expense.domain.Entry;
import com.bharatonjava.expense.domain.Group;

public class ExpenseDaoImpl implements ExpenseDao {

	private static final Log log = LogFactory.getLog(ExpenseDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Entry> getEntries(String type) {

		String sql = "select E.ENTRY_ID,E.ENTRY_DATE,E.ENTRY_DETAIL,E.AMOUNT, "
				+ "G.GROUP_ID,G.GROUP_NAME,G.GROUP_VALUE "
				+ "from entries e join groups g on e.group_id = g.group_id ORDER BY E.ENTRY_ID";
		List<Entry> entries = this.jdbcTemplate
				.query(sql, new EntryRowMapper());
		System.out.println("entries dao " + entries.size());
		return entries;
	}

	public List<Group> getGroups(String type) {
		String sql = "SELECT * FROM GROUPS G WHERE G.GROUP_NAME LIKE ?";
		List<Group> groups = this.jdbcTemplate.query(sql, new GroupRowMapper(),
				new Object[] { type });
		return groups;
	}

	public Group getGroupByValue(String groupValue) {
		log.info("groupValue : " + groupValue);
		String sql = "SELECT * FROM GROUPS G WHERE G.GROUP_ID LIKE ?";
		Group group = (Group) this.jdbcTemplate.queryForObject(sql,
				new GroupRowMapper(), new Object[] { groupValue });
		log.info("returning : " + group);
		return group;
	}

	@Override
	public int saveEntry(Entry entry) {
		log.info(entry);
		String sql = "INSERT INTO ENTRIES(ENTRY_DATE,ENTRY_DETAIL,GROUP_ID,AMOUNT)"
				+ " VALUES (?,?,?,?)";
		int count = this.jdbcTemplate.update(sql,
				new Object[] { entry.getEntryDate(), entry.getEntryDetail(),
						entry.getGroup().getGroupId(), entry.getAmount() });
		
		return count;
	}
}
