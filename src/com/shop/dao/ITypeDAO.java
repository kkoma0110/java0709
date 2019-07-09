package com.shop.dao;

import java.util.List;

import com.shop.po.Goods;
import com.shop.po.Type;
import com.shop.po.User;

public interface ITypeDAO {
		
	void save(Type t);
	void delete(int tid);
	void update(Type t);
	Type findOne(int tid);
	List<Type> findAll();
}
