package com.cn.area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cn.jdbc.JDBC_Connection;

public class AddArea {

	public void addArea(AreaVo areaVo){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			//添加数据的sql语句
			String sql = 
				"insert into area(street,area,address) values(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, areaVo.getStreet());
			pstm.setString(2, areaVo.getArea());
			pstm.setString(3, areaVo.getAddress());
			pstm.executeUpdate();//提交pstm对象

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}

}
