package com.cn.bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class DeleteBike {
	
	public void deleteBike(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =JDBC_Connection.getConnection();
			String sql = "delete from bikes where id =?";
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
	
	public void deleteBikeUser(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =JDBC_Connection.getConnection();
			String sql = "delete from bike_user where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);//给sql语句里的id赋值
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);//关闭连接
		}
		
	}
public static void main(String[] args) {
	}

}
