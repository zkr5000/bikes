package com.cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
	static String drivername ="com.mysql.jdbc.Driver";//mysql���ݿ�����
	static String url="jdbc:mysql://localhost:3306/bike";//���ӵ����ݿ��ַ
	static String username="root";//�������ݿ��û���
	static String password="123456";//�������ݿ�����
	//���������ľ�̬�����
	static{
		try {
			Class.forName(drivername);//��������
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�����������");
			e.printStackTrace();
		}
	}
	/**
	 * �������ݿ�ķ���
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);//��������
			System.out.println("�������ݿ�ɹ���");
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�����url��username����password");
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �÷������ڹرս���������Ӻ�Statement����
	 * @param rs
	 * @param conn
	 * @param stmt
	 */
	public static void free(ResultSet rs,Connection conn ,Statement stmt){
		
			try {
				if(rs !=null)
					rs.close();//�رս����
			} catch (SQLException e) {
				System.out.println("�ر�ResultSetʧ�ܣ�");
				e.printStackTrace();
			}finally {
				
					try {
						if(conn != null)
							conn.close();//�ر�����
					} catch (SQLException e) {
						System.out.println("�ر�Connectionʧ�ܣ�");
						e.printStackTrace();
					}finally{
						try {
							if(stmt != null)
								stmt.close();//�ر�Statement����
						} catch (SQLException e) {
							System.out.println("�ر�Statementʧ�ܣ�");
							e.printStackTrace();
						}
					}
			}
	}
public static void main(String[] args) {
	//���ø����getConnection���������������Ƿ�ɹ�
	JDBC_Connection.getConnection();
}
}
