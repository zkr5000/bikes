package com.cn.customers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCustomerByIdServlet extends HttpServlet {

	
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String code = request.getParameter("code");
		
		customersVo vo = new customersVo();
		
		ShowCustomerById customerById = new ShowCustomerById();
		vo =(customersVo)customerById.showById(id);
		request.setAttribute("vo", vo);
		if(code.equals("show")){
			request.getRequestDispatcher("customers/showCstomerById.jsp").forward(request, response);
			}else if(code.equals("update")){
				request.getRequestDispatcher("customers/updateCustomer.jsp").forward(request, response);
			}
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		
	}

}
