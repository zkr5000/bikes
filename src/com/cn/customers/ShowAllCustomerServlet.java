package com.cn.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllCustomerServlet extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
		List<customersVo> list = new ArrayList<customersVo>();
		ShowAllCustomer allCustomer = new ShowAllCustomer();
		
		String page1 = request.getParameter("page");//���ҳ�洫�ݹ�����pageֵ��ֵ��page1
		int page =1;
		if(page1 != null){
			page = Integer.parseInt(page1);//���ҳ�洫�ݹ�����pageֵ���ڣ���Ѹ�page1��ֵ��page����
		}
		list = allCustomer.showByPage(page);//���ò�ѯ����
		int maxpage = allCustomer.maxpage();//�������ҳ������
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.getRequestDispatcher("customers/showCustomer.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		
	}

}
