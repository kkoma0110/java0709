package com.shop.service.impl;

import java.util.List;

import com.shop.dao.DAOFactory;
import com.shop.po.Goods;
import com.shop.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {
	

	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		List<Goods> gs = DAOFactory.getGoodsDAO().findAll();
		return gs;
	}

	@Override
	public void add(Goods g) {
		// TODO Auto-generated method stub
		DAOFactory.getGoodsDAO().save(g);
		
	}

	@Override
	public Goods findOne(int gid) {
		// TODO Auto-generated method stub
		Goods g = DAOFactory.getGoodsDAO().findOne(gid);
		return g;
	}

	@Override
	public void update(Goods g) {
		// TODO Auto-generated method stub
		DAOFactory.getGoodsDAO().update(g);
	}

	@Override
	public void delete(int gid) {
		// TODO Auto-generated method stub
		DAOFactory.getGoodsDAO().delete(gid);
	}

	

	


}
