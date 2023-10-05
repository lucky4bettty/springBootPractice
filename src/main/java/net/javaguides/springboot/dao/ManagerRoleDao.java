package net.javaguides.springboot.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.StringUtils;

import net.javaguides.springboot.controller.role.RoleForm;
import net.javaguides.springboot.mdbs.jdbc.Page;
import net.javaguides.springboot.mdbs.jdbc.PagingParameter;
import net.javaguides.springboot.mdbs.jdbc.SimpleJdbc;
import net.javaguides.springboot.model.Manager;
import net.javaguides.springboot.model.ManagerRole;


@Repository
public class ManagerRoleDao {
		
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	public final static String TABLE_NAME = "HG_MANAGER_ROLE";

    public ManagerRoleDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<ManagerRole> list(RoleForm data) {
		List<Object> args = new ArrayList<Object>();
        StringBuffer sb = new StringBuffer("SELECT * FROM ");
        sb.append(TABLE_NAME);
        sb.append(" WHERE ID IS NOT NULL");

        
        if(data.getName() != null ) {
        	sb.append(" AND NAME LIKE ?");
        	args.add("%" + data.getName() + "%");
        }
        
        if(data.getStatus() != null && data.getStatus() != "") {
        	sb.append(" AND STATUS LIKE ?");
        	args.add("%" + data.getStatus() + "%");
        }
        

        List<ManagerRole> listManagers = jdbcTemplate.query(sb.toString(), args.toArray(), BeanPropertyRowMapper.newInstance(ManagerRole.class));
        return listManagers ;
    }
	
//	sb.append(" WHERE ID IS NOT NULL");
//	if (StringUtils.isNotBlank(name)) {
//		sb.append(" AND NAME LIKE ?");
//		args.add("%" + name + "%");
//	}
//	if (StringUtils.isNotBlank(status)) {
//		sb.append(" AND STATUS = ?");
//		args.add(status);
//	}
	
	public void save(ManagerRole data) {
		SimpleJdbcInsert insertActorInsert = new SimpleJdbcInsert(jdbcTemplate);
		insertActorInsert.withTableName(TABLE_NAME).usingColumns("NAME","STATUS","ID","CREATE_TIME","MODIFY_TIME");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(data);
		insertActorInsert.execute(param);
  }
	
	public ManagerRole get(String id) {
	    StringBuffer sb = new StringBuffer("SELECT * FROM ");
	    sb.append(TABLE_NAME);
	    sb.append(" WHERE id = ?");
	    String sql = sb.toString();
	    
	    sb.append(id);
		
		Object[] args = {id};
		
		@SuppressWarnings("deprecation")
		ManagerRole data = jdbcTemplate.queryForObject(sql, args ,BeanPropertyRowMapper.newInstance(ManagerRole.class));
		

       return data ;
  }
	
	
	public void update(ManagerRole entity) {
		
		String sql = "UPDATE " + TABLE_NAME + " SET NAME=?, STATUS=?, MODIFIER=?, MODIFY_TIME=? WHERE ID=?";
		Object[] args = { entity.getName(), entity.getStatus(), entity.getModifier(), entity.getModify_time(),
				entity.getId() };
		jdbcTemplate.update(sql, args);
				

  }
	
	public void deleteOne(String id) {
			String sql = "DELETE  FROM "+TABLE_NAME +" WHERE id = ?";
			jdbcTemplate.update(sql, id);
	}
	

	

	
	

}
