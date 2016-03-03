package com.cn.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cn.jdbc.JDBC_Connection;

public class ShowAllCustomer {
	public List<customersVo> showByPage(int page){//��ҳ��ѯ����
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<customersVo> list = new ArrayList<customersVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from customers order by id asc";//��ҳ��ѯ��SQL��䣬ÿҳ��ʾ10����¼
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				customersVo customersVo = new customersVo();
				//	�Ѹ����Է���CarsVo������
			
				
				customersVo.setId(rs.getInt("id"));
				customersVo.setIdentity(rs.getString("identity"));
				customersVo.setCustname(rs.getString("custname"));
				customersVo.setSex(rs.getInt("sex"));
				customersVo.setAddress(rs.getString("address"));
				customersVo.setPhone(rs.getString("phone"));
				customersVo.setCareer(rs.getString("career"));
				customersVo.setPassword(rs.getString("password"));
				
				list.add(customersVo);//��CarsVo������뼯����
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
			String sql ="select count(*) from customers";//��ѯ�ܼ�¼����SQL���
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
