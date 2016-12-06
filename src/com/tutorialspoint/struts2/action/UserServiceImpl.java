package com.tutorialspoint.struts2.action;

import com.tutorialspoint.struts2.dao.BaseDao;

public class UserServiceImpl implements UserService {
private BaseDao dao;
	public boolean login(User user) {
		// TODO Auto-generated method stub
		
		return dao.IsExist(user);
	}
	public BaseDao getDao() {
		return dao;
	}
	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

}
