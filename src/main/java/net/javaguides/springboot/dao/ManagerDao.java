package net.javaguides.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Manager;
import net.javaguides.springboot.model.ManagerRole;

@Repository
public class ManagerDao {
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	public final static String TABLE_NAME = "HG_MANAGER";


    public ManagerDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
    
	/**
	 * 依使用者帳號及密碼取得管理者資訊
	 * 
	 * @param account
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public Manager login(String account, String pwd) throws Exception {
		Object[] args = { account, pwd };
		StringBuffer sb = new StringBuffer("SELECT * FROM ");
		sb.append(TABLE_NAME);
		sb.append(" WHERE ACCOUNT = ? AND PWD = ? "); // 這個有問題
		
		List<Manager> listManagers = jdbcTemplate.query(sb.toString(), args ,BeanPropertyRowMapper.newInstance(Manager.class));

		if (listManagers == null || listManagers.size() == 0) {
			return null;
		}else {
			return listManagers.get(0);
		}
		
		
	}
    
}
