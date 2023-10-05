package net.javaguides.springboot.dao;

import java.util.List;

import net.javaguides.springboot.model.ManagerTask;

public class ManagerTaskDao {

	public final static String TABLE_NAME = "HG_MANAGER_TASK";
	public final static String TABLE_NAME_MRT = "HG_MANAGER_ROLE_TASK";


	/**
	 * 依ID取得單一物件
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
//	public ManagerTask get(String id) throws Exception {
//		StringBuffer sb = new StringBuffer("SELECT * FROM ");
//		sb.append(TABLE_NAME);
//		sb.append(" WHERE ID = ?");
//		Object[] args = { id };
//		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(ManagerTask.class)));
//	}
}
