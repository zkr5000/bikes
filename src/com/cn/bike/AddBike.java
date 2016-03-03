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
			//����JDBC_Connection���getConnection�����������ݿ�
			conn = JDBC_Connection.getConnection();
			//������ݵ�sql���
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
