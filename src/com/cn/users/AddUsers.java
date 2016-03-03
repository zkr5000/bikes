package com.cn.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class AddUsers {
	public void addusers(UsersVo usersVo){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn= JDBC_Connection.getConnection();
			String sql = 
				"insert into users(username,identity,fullname,sex,address,phone,position,userlevel,password) values (?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usersVo.getUsername());
			pstm.setString(2, usersVo.getIdentity());
			pstm.setString(3, usersVo.getFullname());
			pstm.setInt(4, usersVo.getSex());
			pstm.setString(5, usersVo.getAddress());
			pstm.setString(6,usersVo.getPhone());
			pstm.setString(7, usersVo.getPosition());
			pstm.setString(8, usersVo.getUserlevel());
			pstm.setString(9, usersVo.getPassword());
			pstm.executeUpdate();
			System.out.println("Ìí¼Óusers³É¹¦£¡");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
