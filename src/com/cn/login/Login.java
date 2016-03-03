package com.cn.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cn.jdbc.JDBC_Connection;
import com.cn.users.UsersVo;

public class Login {
	public UsersVo  check (String username){
		
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		UsersVo usersVo = new UsersVo();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from users where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				//	把各属性放入UsersVo对象中
				usersVo.setId(rs.getInt("id"));
				usersVo.setUsername(rs.getString("username"));
				usersVo.setIdentity(rs.getString("identity"));
				usersVo.setFullname(rs.getString("fullname"));
				usersVo.setSex(rs.getInt("sex"));
				usersVo.setAddress(rs.getString("address"));
				usersVo.setPhone(rs.getString("phone"));
				usersVo.setPosition(rs.getString("position"));
				usersVo.setUserlevel(rs.getString("userlevel"));
				usersVo.setPassword(rs.getString("password"));
				
			}
			return usersVo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		
	}

}
