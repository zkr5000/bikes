package com.cn.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cn.jdbc.JDBC_Connection;

public class ShowAllCustomer {
	public List<customersVo> showByPage(int page){//分页查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<customersVo> list = new ArrayList<customersVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from customers order by id asc";//分页查询的SQL语句，每页显示10条记录
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				customersVo customersVo = new customersVo();
				//	把各属性放入CarsVo对象中
			
				
				customersVo.setId(rs.getInt("id"));
				customersVo.setIdentity(rs.getString("identity"));
				customersVo.setCustname(rs.getString("custname"));
				customersVo.setSex(rs.getInt("sex"));
				customersVo.setAddress(rs.getString("address"));
				customersVo.setPhone(rs.getString("phone"));
				customersVo.setCareer(rs.getString("career"));
				customersVo.setPassword(rs.getString("password"));
				
				list.add(customersVo);//把CarsVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list;
	}
	public int maxpage(){//获取最大页数查询方法
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count =0;//声明一个count变量，用于存储记录数
		int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
		try {
			conn  = JDBC_Connection.getConnection();
			stmt = conn.createStatement();
			String sql ="select count(*) from customers";//查询总记录数的SQL语句
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);//如果结果集存在，记录数初始化值为1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
		return maxpage;
	}

}
