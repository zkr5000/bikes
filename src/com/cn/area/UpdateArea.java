package com.cn.area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class UpdateArea {
	public void updatearea(AreaVo bikesVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//����id�޸ĵ�sql���

		try {
			//�޸�sql���
			String sql = 
				"update area set area=?, address=? ,street=? where id = ?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//��ֵ���õ��޸ĵ�sql�����
			pstmt.setString(1, bikesVo.getArea());
			pstmt.setString(2, bikesVo.getAddress());
			pstmt.setString(3, bikesVo.getStreet());
			pstmt.setInt(4, bikesVo.getId());
			pstmt.executeUpdate();//ִ���޸�sql���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}

}
