package com.cn.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cn.jdbc.JDBC_Connection;

public class ShowCustomerById {
	public customersVo showById(int id){
		customersVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("select * from customers where id = ?");
			pstmt.setInt(1, id);//…Ë÷√Ãıº˛id
			rs =pstmt.executeQuery();
			while(rs.next()){
				
				vo= new customersVo();
				vo.setIdentity(rs.getString("identity"));
				vo.setCustname(rs.getString("custname"));
				vo.setSex(rs.getInt("sex"));
				vo.setAddress(rs.getString("address"));
				vo.setPhone(rs.getString("phone"));
				vo.setCareer(rs.getString("career"));
				vo.setPassword(rs.getString("password"));
				vo.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		return vo;
	}
}
