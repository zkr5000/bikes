package com.cn.bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;


public class QueryById {
	public BikesVo queryById(int id){
		BikesVo bikesVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("select * from bikes where id = ?");
			pstmt.setInt(1, id);//…Ë÷√Ãıº˛id
			rs =pstmt.executeQuery();
			while(rs.next()){
				bikesVo= new BikesVo();
				bikesVo.setBikenumber(rs.getString("bikenumber"));
				bikesVo.setBiketype(rs.getString("biketype"));
				bikesVo.setColor(rs.getString("color"));
				bikesVo.setDeposit(rs.getDouble("deposit"));
				bikesVo.setDescription(rs.getString("description"));
				bikesVo.setIsrenting(rs.getInt("isrenting"));
				bikesVo.setPrice(rs.getDouble("price"));
				bikesVo.setRentprice(rs.getDouble("rentprice"));
				bikesVo.setId(rs.getInt("id"));
				
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		return bikesVo;
	}

}
