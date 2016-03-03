package com.cn.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class ShowUserById {
	public UsersVo showById(int id) {
		UsersVo usersVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("select * from users where id = ?");
			pstmt.setInt(1, id);//…Ë÷√Ãıº˛id
			rs =pstmt.executeQuery();
			while(rs.next()){
				usersVo= new UsersVo();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return usersVo;
	}
}
