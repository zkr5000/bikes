package com.cn.bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cn.bike.BikesVo;
import com.cn.jdbc.JDBC_Connection;

public class ShowBikes {
	public List<BikesVo> showByPage(int page){//��ҳ��ѯ����
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<BikesVo> list = new ArrayList<BikesVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from bikes order by id asc";//��ҳ��ѯ��SQL��䣬ÿҳ��ʾ5����¼
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BikesVo bikesVo = new BikesVo();
				//	�Ѹ����Է���BikesVo������
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setBikenumber(rs.getString("bikenumber"));
				bikesVo.setBiketype(rs.getString("biketype"));
				bikesVo.setColor(rs.getString("color"));
				bikesVo.setPrice(rs.getDouble("price"));
				bikesVo.setRentprice(rs.getDouble("rentprice"));
				bikesVo.setDeposit(rs.getDouble("deposit"));
				bikesVo.setIsrenting(rs.getInt("isrenting"));
				bikesVo.setDescription(rs.getString("description"));
				
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
	
	public List<BikesVo> showBikes(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BikesVo> list = new ArrayList<BikesVo>();
		try {
			String sql = "select * from bikes";//��ѯȫ��SQL���
			conn = JDBC_Connection.getConnection();//�������ݿ�
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				BikesVo bikesVo = new BikesVo();
				//�Ѹ����Է���CarsVo������
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setBikenumber(rs.getString("bikenumber"));
				bikesVo.setBiketype(rs.getString("biketype"));
				bikesVo.setColor(rs.getString("color"));
				bikesVo.setPrice(rs.getDouble("price"));
				bikesVo.setRentprice(rs.getDouble("rentprice"));
				bikesVo.setDeposit(rs.getDouble("deposit"));
				bikesVo.setIsrenting(rs.getInt("isrenting"));
				bikesVo.setDescription(rs.getString("description"));
				
				list.add(bikesVo);//��CarsVo������뼯����
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//�ر�����
		}
		return list;
	}
	
	public List<BikesUserVo> showBikeUser(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BikesUserVo> list = new ArrayList<BikesUserVo>();
		try {
			String sql = "select t.id,t.userid,t.bikeid,u.username,b.bikenumber,b.biketype,b.color,b.price,b.rentprice,b.deposit from bike_user t,bikes b,users u where t.userid=u.id and b.id=t.bikeid";//��ѯȫ��SQL���
			conn = JDBC_Connection.getConnection();//�������ݿ�
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				BikesUserVo bikesUserVo=new BikesUserVo();
				
				bikesUserVo.setId(rs.getInt("id"));
				bikesUserVo.setUserid(rs.getInt("userid"));
				bikesUserVo.setBikeid(rs.getInt("bikeid"));
				bikesUserVo.setBikenumber(rs.getString("bikenumber"));
				bikesUserVo.setBiketype(rs.getString("biketype"));
				bikesUserVo.setColor(rs.getString("color"));
				bikesUserVo.setPrice(rs.getDouble("price"));
				bikesUserVo.setRentprice(rs.getDouble("rentprice"));
				bikesUserVo.setDeposit(rs.getDouble("deposit"));
				bikesUserVo.setUsername(rs.getString("username"));
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
	
	public void rentBike(String id,String userid){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//����JDBC_Connection���getConnection�����������ݿ�
			conn = JDBC_Connection.getConnection();
			//������ݵ�sql���
			String sql = 
				"insert into bike_user(userid,bikeid) values(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			pstm.setString(2, id);
			pstm.executeUpdate();//�ύpstm����
			System.out.println("��ӳɹ�����ӵ��������£�");
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
	
	public void setBikeArea(String id,String bikeid){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//����JDBC_Connection���getConnection�����������ݿ�
			conn = JDBC_Connection.getConnection();
			//������ݵ�sql���
			String sql = 
				"insert into bikes_area(areaid,bikeid) values(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, bikeid);
			pstm.executeUpdate();//�ύpstm����
			System.out.println("��ӳɹ�����ӵ��������£�");
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}


}
