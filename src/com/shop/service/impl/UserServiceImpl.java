package com.shop.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shop.dao.DAOFactory;
import com.shop.po.User;
import com.shop.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	@Override
	public void save(User u) {
		DAOFactory.getUserDAO().save(u);
		
	}

	@Override
	public void update(User u) {
		DAOFactory.getUserDAO().update(u);
		
	}

	@Override
	public void delete(int uid) {
		DAOFactory.getUserDAO().delete(uid);
		
	}

	@Override
	public User findOne(int uid) {
		
		return DAOFactory.getUserDAO().findOne(uid);
	}

	@Override
	public List<User> findAll() {
		
		return DAOFactory.getUserDAO().findAll();
	}

	@Override
	public String login(String uname, String password, HttpServletRequest request) {
		User loginUser = DAOFactory.getUserDAO().login(uname, password);
		if(loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
			return "true";
		}
		else {
			return "false";
		}
	}

	@Override
	public void out(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
	}

}
