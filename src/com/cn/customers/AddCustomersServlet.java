package com.cn.customers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomersServlet extends HttpServlet {


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
		
		String identity =request.getParameter("identity");//���֤
		String custname =request.getParameter("custname");//����
		int sex =Integer.parseInt(request.getParameter("sex"));//�Ա�
		String address =request.getParameter("address");//��ַ
		String phone =request.getParameter("phone");//�绰
		String career =request.getParameter("career");//ְҵ
		String password =request.getParameter("password");//����
		
		customersVo customersVo = new customersVo();
		customersVo.setIdentity(identity);
		customersVo.setCustname(custname);
		customersVo.setSex(sex);
		customersVo.setAddress(address);
		customersVo.setPhone(phone);
		customersVo.setCareer(career);
		customersVo.setPassword(password);
		AddCustomers addCustomers = new AddCustomers();
		addCustomers.addCustomer(customersVo);
		response.sendRedirect("ShowAllCustomerServlet");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		
	}

}
