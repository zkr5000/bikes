package com.cn.customers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCustomerServlet extends HttpServlet {

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
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
		UpdateCustomer updateCustomer =new UpdateCustomer();
		
		String identity =request.getParameter("identity");//身份证
		String custname =request.getParameter("custname");//姓名
		int sex =Integer.parseInt(request.getParameter("sex"));//性别
		String address =request.getParameter("address");//地址
		String phone =request.getParameter("phone");//电话
		String career =request.getParameter("career");//职业
		String password =request.getParameter("password");//密码
		int id =Integer.parseInt(request.getParameter("id"));
		customersVo customersVo = new customersVo();
		customersVo.setIdentity(identity);
		customersVo.setCustname(custname);
		customersVo.setSex(sex);
		customersVo.setAddress(address);
		customersVo.setPhone(phone);
		customersVo.setCareer(career);
		customersVo.setPassword(password);
		customersVo.setId(id);
		updateCustomer.updateCustomer(customersVo);
		response.sendRedirect("ShowAllCustomerServlet");
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
