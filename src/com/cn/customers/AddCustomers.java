package com.cn.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cn.jdbc.JDBC_Connection;

public class AddCustomers {
	public void addCustomer(customersVo customersVo){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			//添加数据的sql语句
			String sql = 
				"insert into customers(identity,custname,sex,address,phone,career,password) values(?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, customersVo.getIdentity());
			pstm.setString(2, customersVo.getCustname());
			pstm.setInt(3, customersVo.getSex());
			pstm.setString(4, customersVo.getAddress());
			pstm.setString(5, customersVo.getPhone());
			pstm.setString(6, customersVo.getCareer());
			pstm.setString(7, customersVo.getPassword());
			pstm.executeUpdate();//提交pstm对象
			System.out.println("添加成功！添加的内容如下：");
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}

}
