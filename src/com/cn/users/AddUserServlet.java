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
		
		//获得页面传递过来的数据
		String username = request.getParameter("username");//登录名
		String identity= request.getParameter("identity");;//身份证
		String fullname= request.getParameter("fullname");;//姓名
		int sex = Integer.parseInt(request.getParameter("sex"));//性别
		String address= request.getParameter("address");;//地址
		String phone= request.getParameter("phone");;//联系电话
		String position= request.getParameter("position");;//职位
		String userlevel= request.getParameter("userlevel");;//用户类型
		String password= request.getParameter("password");;//密码
		//下面的步骤是把获得的数据放入usersVo对象中
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
		System.out.println("添加成功！");
		response.sendRedirect("ShowUsersServlet");
		out.flush();
		out.close();
	}

}
