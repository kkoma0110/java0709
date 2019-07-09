package com.shop.service;

import java.util.List;

import com.shop.po.Goods;

public interface IGoodsService {

	List<Goods> findAll();

	void add(Goods g);

	Goods findOne(int gid);

	void update(Goods g);

	void delete(int gid);
	

}
