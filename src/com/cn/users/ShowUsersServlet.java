package com.cn.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowUsersServlet extends HttpServlet {

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
		ShowUsers showUsers = new ShowUsers();
		List<UsersVo> list = new ArrayList<UsersVo>();
		String page1 = request.getParameter("page");//���ҳ�洫�ݹ�����pageֵ��ֵ��page1
		int page =1;
		if(page1 != null){
			page = Integer.parseInt(page1);//���ҳ�洫�ݹ�����pageֵ���ڣ���Ѹ�page1��ֵ��page����
		}
		list = showUsers.showByPage(page);//���ò�ѯ����
		int maxpage = showUsers.maxpage();//�������ҳ������
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.getRequestDispatcher("users/showUsers.jsp").forward(request, response);
		out.flush();
		out.close();
	}
}