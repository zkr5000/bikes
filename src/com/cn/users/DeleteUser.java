package com.cn.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class DeleteUser {
	public void deleteUser(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =JDBC_Connection.getConnection();
			String sql = "delete from users where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);//给sql语句里的id赋值
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);//关闭连接
		}
		
	}

}
