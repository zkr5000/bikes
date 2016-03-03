package com.cn.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class DeleteCustomer {
	public void deleteCustomer(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =JDBC_Connection.getConnection();
			String sql = "delete from customers where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);//��sql������id��ֵ
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);//�ر�����
		}
		
		
	}

}
