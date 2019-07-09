package com.shop.dao;

import com.shop.dao.impl.GoodsDAOImpl;
import com.shop.dao.impl.TypeDAOImpl;
import com.shop.dao.impl.UserDAOImpl;

public class DAOFactory {
		
		public static IUserDAO getUserDAO(){
			return new UserDAOImpl();
		}
		
		public static IGoodsDAO getGoodsDAO(){
			return new GoodsDAOImpl();
		}
		
		public static ITypeDAO getTypeDAO(){
			return new TypeDAOImpl();
		}
}
