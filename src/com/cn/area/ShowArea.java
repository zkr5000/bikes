package com.cn.area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cn.bike.BikesVo;
import com.cn.jdbc.JDBC_Connection;

public class ShowArea {
	public List<AreaVo> showByPage(int page){//��ҳ��ѯ����
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<AreaVo> list = new ArrayList<AreaVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from area order by id asc";//��ҳ��ѯ��SQL��䣬ÿҳ��ʾ5����¼
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AreaVo bikesVo = new AreaVo();
				//	�Ѹ����Է���BikesVo������
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setArea(rs.getString("area"));
				bikesVo.setAddress(rs.getString("address"));
				bikesVo.setStreet(rs.getString("street"));
				list.add(bikesVo);//��BikesVo������뼯����
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
			String sql ="select count(*) from bikes";//��ѯ�ܼ�¼����SQL���
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
	
	public List<AreaVo> showArea(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<AreaVo> list = new ArrayList<AreaVo>();
		try {
			String sql = "select * from area";//��ѯȫ��SQL���
			conn = JDBC_Connection.getConnection();//�������ݿ�
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				AreaVo bikesVo = new AreaVo();
				//	�Ѹ����Է���BikesVo������
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setArea(rs.getString("area"));
				bikesVo.setAddress(rs.getString("address"));
				bikesVo.setStreet(rs.getString("street"));
				list.add(bikesVo);//��BikesVo������뼯����
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//�ر�����
		}
		return list;
	}
	
	public List<AreaBikeVo> showBikeArea(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<AreaBikeVo> list = new ArrayList<AreaBikeVo>();
		try {
			String sql = "select t.id,t.areaid,t.bikeid,a.area,a.street,a.address,b.bikenumber,b.biketype,b.color,b.price,b.rentprice,b.deposit from bikes_area t,bikes b,area a where t.areaid=a.id and b.id=t.bikeid";//��ѯȫ��SQL���
			conn = JDBC_Connection.getConnection();//�������ݿ�
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				AreaBikeVo bikesUserVo=new AreaBikeVo();
				
				bikesUserVo.setId(rs.getInt("id"));
				bikesUserVo.setAreaid(rs.getInt("areaid"));
				bikesUserVo.setBikeid(rs.getInt("bikeid"));
				bikesUserVo.setBikenumber(rs.getString("bikenumber"));
				bikesUserVo.setBiketype(rs.getString("biketype"));
				bikesUserVo.setColor(rs.getString("color"));
				bikesUserVo.setPrice(rs.getDouble("price"));
				bikesUserVo.setRentprice(rs.getDouble("rentprice"));
				bikesUserVo.setDeposit(rs.getDouble("deposit"));
				bikesUserVo.setArea(rs.getString("area"));
				bikesUserVo.setStreet(rs.getString("street"));
				bikesUserVo.setAddress(rs.getString("address"));
				list.add(bikesUserVo);//��CarsVo������뼯����
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//�ر�����
		}
		return list;
	}

}
