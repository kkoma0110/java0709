package com.shop.service;

import java.util.List;

import com.shop.po.Type;

public interface ITypeService {

	List<Type> findAllType();

	void addType(Type type);

	void deleteByTid(int tid);

	Type findById(int tid);

	void update(Type type);

}
