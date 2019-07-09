package com.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shop.po.User;

public interface IUserService {
	void save(User u);
	void update(User u);
	void delete(int uid);
	User findOne(int uid);
	List<User> findAll();
	void out(HttpServletRequest request);
	String login(String uname, String password, HttpServletRequest request);
}