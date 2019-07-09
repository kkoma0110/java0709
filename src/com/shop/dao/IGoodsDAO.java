package com.shop.dao;

import java.util.List;

import com.shop.po.Goods;
import com.shop.po.User;

public interface IGoodsDAO {
	
	void save(Goods g);
	void delete(int gid);
	void update(Goods g);
	Goods findOne(int gid);
	List<Goods> findAll();
}
