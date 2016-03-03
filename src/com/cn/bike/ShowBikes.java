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
	public List<BikesVo> showByPage(int page){//分页查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<BikesVo> list = new ArrayList<BikesVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from bikes order by id asc";//分页查询的SQL语句，每页显示5条记录
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BikesVo bikesVo = new BikesVo();
				//	把各属性放入BikesVo对象中
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setBikenumber(rs.getString("bikenumber"));
				bikesVo.setBiketype(rs.getString("biketype"));
				bikesVo.setColor(rs.getString("color"));
				bikesVo.setPrice(rs.getDouble("price"));
				bikesVo.setRentprice(rs.getDouble("rentprice"));
				bikesVo.setDeposit(rs.getDouble("deposit"));
				bikesVo.setIsrenting(rs.getInt("isrenting"));
				bikesVo.setDescription(rs.getString("description"));
				
				list.add(bikesVo);//把BikesVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list;
	}
	public int maxpage(){//获取最大页数查询方法
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count =0;//声明一个count变量，用于存储记录数
		int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
		try {
			conn  = JDBC_Connection.getConnection();
			stmt = conn.createStatement();
			String sql ="select count(*) from bikes";//查询总记录数的SQL语句
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);//如果结果集存在，记录数初始化值为1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
		return maxpage;
	}
	
	public List<BikesVo> showBikes(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BikesVo> list = new ArrayList<BikesVo>();
		try {
			String sql = "select * from bikes";//查询全部SQL语句
			conn = JDBC_Connection.getConnection();//连接数据库
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				BikesVo bikesVo = new BikesVo();
				//把各属性放入CarsVo对象中
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setBikenumber(rs.getString("bikenumber"));
				bikesVo.setBiketype(rs.getString("biketype"));
				bikesVo.setColor(rs.getString("color"));
				bikesVo.setPrice(rs.getDouble("price"));
				bikesVo.setRentprice(rs.getDouble("rentprice"));
				bikesVo.setDeposit(rs.getDouble("deposit"));
				bikesVo.setIsrenting(rs.getInt("isrenting"));
				bikesVo.setDescription(rs.getString("description"));
				
				list.add(bikesVo);//把CarsVo对象放入集合中
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//关闭连接
		}
		return list;
	}
	
	public List<BikesUserVo> showBikeUser(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BikesUserVo> list = new ArrayList<BikesUserVo>();
		try {
			String sql = "select t.id,t.userid,t.bikeid,u.username,b.bikenumber,b.biketype,b.color,b.price,b.rentprice,b.deposit from bike_user t,bikes b,users u where t.userid=u.id and b.id=t.bikeid";//查询全部SQL语句
			conn = JDBC_Connection.getConnection();//连接数据库
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
				list.add(bikesUserVo);//把CarsVo对象放入集合中
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//关闭连接
		}
		return list;
	}
	
	public void rentBike(String id,String userid){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			//添加数据的sql语句
			String sql = 
				"insert into bike_user(userid,bikeid) values(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			pstm.setString(2, id);
			pstm.executeUpdate();//提交pstm对象
			System.out.println("添加成功！添加的内容如下：");
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
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			//添加数据的sql语句
			String sql = 
				"insert into bikes_area(areaid,bikeid) values(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, bikeid);
			pstm.executeUpdate();//提交pstm对象
			System.out.println("添加成功！添加的内容如下：");
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}


}
