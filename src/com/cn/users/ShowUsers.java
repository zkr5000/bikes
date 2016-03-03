package com.cn.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cn.jdbc.JDBC_Connection;

public class ShowUsers {
	public List<UsersVo> showByPage(int page){//��ҳ��ѯ����
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<UsersVo> list = new ArrayList<UsersVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from users order by id asc";//��ҳ��ѯ��SQL��䣬ÿҳ��ʾ5����¼
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				UsersVo usersVo = new UsersVo();
				//	�Ѹ����Է���UsersVo������
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
				
				list.add(usersVo);//��UsersVo������뼯����
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list;
	}
	public int maxpage(){//��ȡ���ҳ����ѯ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count =0;//����һ��count���������ڴ洢��¼��
		int maxpage = 0;//����һ��maxpage������ԭ����ʾ���ҳ��
		try {
			conn  = JDBC_Connection.getConnection();
			stmt = conn.createStatement();
			String sql ="select count(*) from users";//��ѯ�ܼ�¼����SQL���
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);//�����������ڣ���¼����ʼ��ֵΪ1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		maxpage = (count+4)/5;//���ҳ�������ܼ�¼��������4���ٳ���5
		return maxpage;
	}

}
