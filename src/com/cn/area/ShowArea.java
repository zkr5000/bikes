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
	public List<AreaVo> showByPage(int page){//分页查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<AreaVo> list = new ArrayList<AreaVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from area order by id asc";//分页查询的SQL语句，每页显示5条记录
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AreaVo bikesVo = new AreaVo();
				//	把各属性放入BikesVo对象中
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setArea(rs.getString("area"));
				bikesVo.setAddress(rs.getString("address"));
				bikesVo.setStreet(rs.getString("street"));
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
	
	public List<AreaVo> showArea(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<AreaVo> list = new ArrayList<AreaVo>();
		try {
			String sql = "select * from area";//查询全部SQL语句
			conn = JDBC_Connection.getConnection();//连接数据库
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				AreaVo bikesVo = new AreaVo();
				//	把各属性放入BikesVo对象中
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setArea(rs.getString("area"));
				bikesVo.setAddress(rs.getString("address"));
				bikesVo.setStreet(rs.getString("street"));
				list.add(bikesVo);//把BikesVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//关闭连接
		}
		return list;
	}
	
	public List<AreaBikeVo> showBikeArea(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<AreaBikeVo> list = new ArrayList<AreaBikeVo>();
		try {
			String sql = "select t.id,t.areaid,t.bikeid,a.area,a.street,a.address,b.bikenumber,b.biketype,b.color,b.price,b.rentprice,b.deposit from bikes_area t,bikes b,area a where t.areaid=a.id and b.id=t.bikeid";//查询全部SQL语句
			conn = JDBC_Connection.getConnection();//连接数据库
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

}
