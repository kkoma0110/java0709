package com.shop.dao;

import java.util.List;

import com.shop.po.User;

public interface IUserDAO {
	void save(User u);
	void delete(int uid);
	void update(User u);
	User findOne(int uid);
	List<User> findAll();
	User login(String uname, String password);
	
}
