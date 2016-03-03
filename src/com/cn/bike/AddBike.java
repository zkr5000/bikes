package com.cn.bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cn.jdbc.JDBC_Connection;

public class AddBike {

	public void addBike(BikesVo bikesVo){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			//添加数据的sql语句
			String sql = 
				"insert into bikes(bikenumber,biketype,color,price,rentprice,deposit,isrenting,description) values(?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bikesVo.getBikenumber());
			pstm.setString(2, bikesVo.getBiketype());
			pstm.setString(3, bikesVo.getColor());
			pstm.setDouble(4, bikesVo.getPrice());
			pstm.setDouble(5, bikesVo.getRentprice());
			pstm.setDouble(6, bikesVo.getDeposit());
			pstm.setInt(7, bikesVo.getIsrenting());
			pstm.setString(8, bikesVo.getDescription());
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
