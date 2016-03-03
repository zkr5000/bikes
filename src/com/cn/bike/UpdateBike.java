package com.cn.bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class UpdateBike {
	public void updatebike(BikesVo bikesVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//����id�޸ĵ�sql���

		try {
			//�޸�sql���
			String sql = 
				"update bikes set bikenumber=?, biketype=? ,color=?, price=?,rentprice=?,deposit=?,isrenting=?,description=? where id = ?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//��ֵ���õ��޸ĵ�sql�����
			pstmt.setString(1, bikesVo.getBikenumber());
			pstmt.setString(2, bikesVo.getBiketype());
			pstmt.setString(3, bikesVo.getColor());
			pstmt.setDouble(4, bikesVo.getPrice());
			pstmt.setDouble(5, bikesVo.getRentprice());
			pstmt.setDouble(6, bikesVo.getDeposit());
			pstmt.setInt(7, bikesVo.getIsrenting());
			pstmt.setString(8, bikesVo.getDescription());
			pstmt.setInt(9, bikesVo.getId());
			pstmt.executeUpdate();//ִ���޸�sql���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}

}
