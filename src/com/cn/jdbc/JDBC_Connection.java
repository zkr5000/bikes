package com.cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
	static String drivername ="com.mysql.jdbc.Driver";//mysql数据库驱动
	static String url="jdbc:mysql://localhost:3306/bike";//连接的数据库地址
	static String username="root";//连接数据库用户名
	static String password="123456";//连接数据库密码
	//创建驱动的静态代码块
	static{
		try {
			Class.forName(drivername);//创建驱动
			System.out.println("创建驱动成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("创建驱动失败！请检查驱动！");
			e.printStackTrace();
		}
	}
	/**
	 * 连接数据库的方法
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);//创建连接
			System.out.println("连接数据库成功！");
		} catch (SQLException e) {
			System.out.println("连接数据库失败！请检查url、username或者password");
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 该方法用于关闭结果集、连接和Statement对象。
	 * @param rs
	 * @param conn
	 * @param stmt
	 */
	public static void free(ResultSet rs,Connection conn ,Statement stmt){
		
			try {
				if(rs !=null)
					rs.close();//关闭结果集
			} catch (SQLException e) {
				System.out.println("关闭ResultSet失败！");
				e.printStackTrace();
			}finally {
				
					try {
						if(conn != null)
							conn.close();//关闭连接
					} catch (SQLException e) {
						System.out.println("关闭Connection失败！");
						e.printStackTrace();
					}finally{
						try {
							if(stmt != null)
								stmt.close();//关闭Statement对象
						} catch (SQLException e) {
							System.out.println("关闭Statement失败！");
							e.printStackTrace();
						}
					}
			}
	}
public static void main(String[] args) {
	//调用该类的getConnection方法，测试连接是否成功
	JDBC_Connection.getConnection();
}
}
