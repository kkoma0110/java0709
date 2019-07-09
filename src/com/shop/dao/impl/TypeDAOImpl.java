package com.shop.dao.impl;

import java.util.List;

import com.shop.dao.ITypeDAO;
import com.shop.po.Type;
import com.shop.po.User;
import com.shop.util.BaseDAO;

public class TypeDAOImpl implements ITypeDAO {
	BaseDAO<Type> bd = new BaseDAO<Type>();
	
	@Override
	public void save(Type t) {
		// TODO Auto-generated method stub
		String sql="insert into type values(null,?,?,?)";
		Object objs[]={t.getTname(),t.getTphoto(),t.getTdesc()};
		bd.update(sql, objs);
	}

	@Override
	public void delete(int tid) {
		// TODO Auto-generated method stub
		String sql="delete from type where tid=?";
		Object objs[]={tid};
		bd.update(sql, objs);
	}

	@Override
	public void update(Type t) {
		// TODO Auto-generated method stub
		String sql="update type  set tname=?,tphoto=?,tdesc=? where tid=?";
		Object objs[]={t.getTname(),t.getTphoto(),t.getTdesc(),t.getTid()};
		bd.update(sql, objs);
	}

	@Override
	public Type findOne(int tid) {
		String sql ="select * from type where tid=?";
		Object objs[]={tid};
		List<Type> types = bd.select(sql, objs, Type.class);
		return types.size()==0?null:types.get(0);
	}

	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		String sql ="select * from type";
		Object objs[]={};
		List<Type> types = bd.select(sql, objs, Type.class);
		return types;
	}

}
