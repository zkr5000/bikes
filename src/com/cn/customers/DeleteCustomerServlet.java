package com.cn.customers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCustomerServlet extends HttpServlet {

	
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
		
		int id  = Integer.parseInt(request.getParameter("id"));
		DeleteCustomer deleteCustomer = new DeleteCustomer();
		deleteCustomer.deleteCustomer(id);
		response.sendRedirect("ShowAllCustomerServlet");
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		
	}

}
