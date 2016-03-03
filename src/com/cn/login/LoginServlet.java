package com.cn.login;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;

//import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.users.UsersVo;

public class LoginServlet extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		List<UsersVo> list = new ArrayList<UsersVo>();
		Login login = new Login();
		UsersVo usersVo = new UsersVo();

		if (username.length() != 0 && password.length() != 0) {
			usersVo = login.check(username);
			if (usersVo != null) {
				if (username.equals(usersVo.getUsername())
						&& password.equals(usersVo.getPassword())) {

					response.sendRedirect("adm_index.jsp");
				} else {
					response.sendRedirect("login/loginError.jsp");
				}
			} else {
				response.sendRedirect("login/login.jsp");
			}
		} else {

		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
