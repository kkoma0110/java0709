package com.shop.dao.impl;

import java.util.List;

import com.shop.dao.IUserDAO;
import com.shop.po.User;
import com.shop.util.BaseDAO;

public class UserDAOImpl implements IUserDAO {
	BaseDAO<User> bd=new BaseDAO<User>();
	@Override
	public void save(User u) {
		String sql="insert into `user` value(null,?,?)";
		Object[] objs={u.getUname(),u.getPassword()};
		bd.update(sql, objs);
	}

	@Override
	public void delete(int uid) {
		String sql="delete from `user` where uid=?";
		Object[] objs={uid};
		bd.update(sql, objs);

	}

	@Override
	public void update(User u) {
		String sql="update `user` set uname=?,password=? where uid=?";
		Object[] objs={u.getUname(),u.getPassword(),u.getUid()};
		bd.update(sql, objs);
	}

	@Override
	public User findOne(int uid) {
		String sql="select * from `user` where uid=?";
		Object[] objs={uid};
		List<User> us=bd.select(sql, objs, User.class);
		return us.size()==0?null:us.get(0);
	}

	@Override
	public List<User> findAll() {
		String sql="select * from `user`";
		Object[] objs={};
		return bd.select(sql, objs, User.class);
	}

	@Override
	public User login(String uname, String password) {
		String sql="select * from `user` where uname=? and password=?";
		Object[] objs={uname, password};
		List<User> us=bd.select(sql, objs, User.class);
		return us.size()==0?null:us.get(0);
	}

}
