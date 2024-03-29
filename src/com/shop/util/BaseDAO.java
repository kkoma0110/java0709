package com.shop.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDAO<T> {
	
	Connection conn;
	PreparedStatement stat;
	ResultSet rs;
	
	public void update(String sql,Object objs[]){
		try {
			conn=jdbcUtils.getConn();
			stat=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				stat.setObject(i+1, objs[i]);
			}
			stat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.closeConn(rs, stat, conn);
		}
		
	}
	
	public List<T> select(String sql,Object objs[],Class c){
		List<T> list = new ArrayList<T>();
		
		try {
			conn=jdbcUtils.getConn();
			stat=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				stat.setObject(i+1, objs[i]);
			}
			rs = stat.executeQuery();
			
			while(rs.next()){
				Object obj = c.newInstance();
				Method ms[] = c.getDeclaredMethods();
				for(Method m:ms){
					String mName = m.getName();
					if(mName.startsWith("set")){
						String fieldName = mName.substring(3);
						Class cs[] =m.getParameterTypes();
						if(cs[0]==String.class){
							m.invoke(obj, rs.getString(fieldName));
						}else if(cs[0]==int.class){
							m.invoke(obj, rs.getInt(fieldName));
						}else if(cs[0]==double.class){
							m.invoke(obj, rs.getDouble(fieldName));
						}else if(cs[0]==Date.class){
							m.invoke(obj, rs.getDate(fieldName));
						}
					}
				}
				list.add((T) obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
