package com.cn.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserServlet extends HttpServlet {

	
	public void destroy() {
		super.destroy(); 
		
	}

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
		System.out.println("����UpdateServlet������");
//		���ҳ�洫�ݹ���������
		String username = request.getParameter("username");//��¼��
		int id= Integer.parseInt(request.getParameter("id"));
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
		usersVo.setId(id);
		usersVo.setUsername(username);
		usersVo.setIdentity(identity);
		usersVo.setFullname(fullname);
		usersVo.setSex(sex);
		usersVo.setAddress(address);
		usersVo.setPhone(phone);
		usersVo.setPosition(position);
		usersVo.setUserlevel(userlevel);
		usersVo.setPassword(password);
		UpdateUser updateUser = new UpdateUser();
		updateUser.updateUser(usersVo);
		System.out.println("�޸ĳɹ���");
		response.sendRedirect("ShowUsersServlet");
		
		out.flush();
		out.close();
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
