package com.cn.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//���ҳ�洫�ݹ���������
		String username = request.getParameter("username");//��¼��
		String identity= request.getParameter("identity");;//���֤
		String fullname= request.getParameter("fullname");;//����
		int sex = Integer.parseInt(request.getParameter("sex"));//�Ա�
		String address= request.getParameter("address");;//��ַ
		String phone= request.getParameter("phone");;//��ϵ�绰
		String position= request.getParameter("position");;//ְλ
		String userlevel= request.getParameter("userlevel");;//�û�����
		String password= request.getParameter("password");;//����
		//����Ĳ����ǰѻ�õ����ݷ���usersVo������
		UsersVo usersVo = new UsersVo();
		usersVo.setUsername(username);
		usersVo.setIdentity(identity);
		usersVo.setFullname(fullname);
		usersVo.setSex(sex);
		usersVo.setAddress(address);
		usersVo.setPhone(phone);
		usersVo.setPosition(position);
		usersVo.setUserlevel(userlevel);
		usersVo.setPassword(password);
		
		AddUsers addUsers = new AddUsers();
		addUsers.addusers(usersVo);
		System.out.println("��ӳɹ���");
		response.sendRedirect("ShowUsersServlet");
		out.flush();
		out.close();
	}

}
