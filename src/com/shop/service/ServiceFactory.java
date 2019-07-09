package com.shop.service;

import com.shop.service.impl.GoodsServiceImpl;
import com.shop.service.impl.TypeServiceImpl;
import com.shop.service.impl.UserServiceImpl;

public class ServiceFactory {
		
	public static IUserService getUserService(){
		return new UserServiceImpl();
	}
	
	public static IGoodsService getGoodsService(){
		return new GoodsServiceImpl();
	}
	
	public static ITypeService getTypeService(){
		return new TypeServiceImpl();
	}
	
}
