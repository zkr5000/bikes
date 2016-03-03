package com.cn.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUserByIDServlet extends HttpServlet {

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
		ShowUserById userById = new ShowUserById();
		UsersVo usersVo = new UsersVo();
		usersVo = userById.showById(id);
		System.out.println(usersVo.getUserlevel());
		request.setAttribute("usersVo", usersVo);
		if(code.equals("show")){
			request.getRequestDispatcher("users/showUserManager.jsp").forward(request, response);
		}else if(code.equals("update")){
			request.getRequestDispatcher("users/updateUsers.jsp").forward(request, response);
		}
		out.flush();
		out.close();
	}

}
