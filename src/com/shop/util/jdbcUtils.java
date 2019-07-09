package com.shop.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 数据库连接的工具类
 * @author Panda
 *
 */
public class jdbcUtils {
	static Connection conn;
	static String driver;
	static String url;
	static String user;
	static String password;
	
	static{
		Properties p = new  Properties();
		try {
			p.load(jdbcUtils.class.getResourceAsStream("db.properties"));
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得连接对象
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	/**
	 * 关闭连接对象
	 */
	public static void closeConn(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
