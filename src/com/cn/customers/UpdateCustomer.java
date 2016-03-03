package com.cn.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class UpdateCustomer {
	public void updateCustomer(customersVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//根据id修改的sql语句
		try {
			//修改sql语句
			String sql = 
				"update customers set identity=?, custname=? ,sex=?, address=?,phone=?,career=?,password=? where id = ?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//把值设置到修改的sql语句中
			pstmt.setString(1, vo.getIdentity());
			pstmt.setString(2, vo.getCustname());
			pstmt.setInt(3, vo.getSex());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getCareer());
			pstmt.setString(7, vo.getPassword());
			pstmt.setInt(8, vo.getId());
			pstmt.executeUpdate();//执行修改sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
		
	}

}
