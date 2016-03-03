package com.cn.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class UpdateUser {
	public void updateUser(UsersVo usersVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//����id�޸ĵ�sql���
		try {
			//�޸�sql���
			String sql = 
				"update users set username=?, identity=? ,fullname=?, sex=?,address=?,phone=?,position=?,userlevel=?,password=? where id = ?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//��ֵ���õ��޸ĵ�sql�����
			pstmt.setString(1, usersVo.getUsername());
			pstmt.setString(2, usersVo.getIdentity());
			pstmt.setString(3, usersVo.getFullname());
			pstmt.setInt(4, usersVo.getSex());
			pstmt.setString(5, usersVo.getAddress());
			pstmt.setString(6, usersVo.getPhone());
			pstmt.setString(7, usersVo.getPosition());
			pstmt.setString(8, usersVo.getUserlevel());
			pstmt.setString(9, usersVo.getPassword());
			pstmt.setInt(10, usersVo.getId());
			pstmt.executeUpdate();//ִ���޸�sql���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
