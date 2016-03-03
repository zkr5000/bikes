package com.cn.area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;


public class QueryById {
	
	public AreaVo queryById(int id){
		AreaVo bikesVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("select * from area where id = ?");
			pstmt.setInt(1, id);//…Ë÷√Ãıº˛id
			rs =pstmt.executeQuery();
			while(rs.next()){
				bikesVo= new AreaVo();
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setArea(rs.getString("area"));
				bikesVo.setAddress(rs.getString("address"));
				bikesVo.setStreet(rs.getString("street"));
		
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
