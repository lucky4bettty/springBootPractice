package net.javaguides.springboot.service;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.controller.role.RoleForm;
import net.javaguides.springboot.dao.ManagerRoleDao;
import net.javaguides.springboot.mdbs.jdbc.Page;
import net.javaguides.springboot.mdbs.jdbc.PagingParameter;
import net.javaguides.springboot.mdbs.util.Id;
import net.javaguides.springboot.model.Manager;
import net.javaguides.springboot.model.ManagerRole;

@Service
public class ManagerRoleService {
	
	@Autowired
	private ManagerRoleDao managerRoleDao;
	
	public List<ManagerRole> getList(RoleForm data){
		return managerRoleDao.list(data);
	}
	
	/**
	 * 取得單一物件
	 * 
	 * @param id
	 * @return ManagerRole
	 * @throws Exception
	 */
	public ManagerRole get(String id) throws Exception {
		return managerRoleDao.get(id);
	}
	
	/**
	 * 新增
	 * 
	 * @param id
	 * @return ManagerRole
	 * @throws Exception
	 */
	public void save(ManagerRole data ,String modifier){
		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());

		data.setId(Id.id20()); 
		data.setCreate_time(now);
		data.setModify_time(now);
		data.setModifier(modifier);

		managerRoleDao.save(data);
	}
	
	/**
	 * 編輯
	 * 
	 * @param id
	 * @return ManagerRole
	 * @throws Exception
	 */
	public void update(ManagerRole data, String modifier){
		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
		data.setModify_time(now);
		data.setModifier(modifier);
		managerRoleDao.update(data);
	}
	
	/**
	 * 刪除
	 * 
	 * @param id
	 * @return ManagerRole
	 * @throws Exception
	 */
	public void delete(String id ,String modifier){
		managerRoleDao.deleteOne(id);
	}
	

	
//	public Page<ManagerRole> findPage(String name, String status, PagingParameter paging) throws Exception {
//		return managerRoleDao.findPage(name, status, paging);
//	}

}
