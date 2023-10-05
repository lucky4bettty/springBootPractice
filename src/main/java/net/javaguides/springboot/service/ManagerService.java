package net.javaguides.springboot.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dao.ManagerDao;
import net.javaguides.springboot.model.Manager;

@Service
public class ManagerService {
	@Autowired
	private ManagerDao managerDao ;
	
	/**
	 * 登入
	 * 
	 * @param account
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public Manager login(String account, String pwd) throws Exception {
		return managerDao.login(account, DigestUtils.md5Hex(pwd));
	}

}
