package com.shop.service.impl;

import java.util.List;

import com.shop.dao.DAOFactory;
import com.shop.po.Type;
import com.shop.service.ITypeService;

public class TypeServiceImpl implements ITypeService {
	
	@Override
	public List<Type> findAllType() {
		// TODO Auto-generated method stub
		return DAOFactory.getTypeDAO().findAll();
	}

	@Override
	public void addType(Type type) {
		// TODO Auto-generated method stub
		 DAOFactory.getTypeDAO().save(type);
	}

	@Override
	public void deleteByTid(int tid) {
		// TODO Auto-generated method stub
		 DAOFactory.getTypeDAO().delete(tid);
	}

	@Override
	public Type findById(int tid) {
		Type type = DAOFactory.getTypeDAO().findOne(tid);
		return type;
	}

	@Override
	public void update(Type type) {
		// TODO Auto-generated method stub
		DAOFactory.getTypeDAO().update(type);
	}

	
}
