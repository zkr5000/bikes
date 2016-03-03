package com.cn.bike;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddBikeServlet extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		BikesVo bikesVo = new BikesVo();
		String bikenumber= request.getParameter("bikenumber");//车号
		String biketype=request.getParameter("biketype");//型号
		String color=request.getParameter("color");//颜色
		double price=Double.parseDouble(request.getParameter("price"));//价值
		double rentprice=Double.parseDouble(request.getParameter("rentprice"));//租金
		double deposit=Double.parseDouble(request.getParameter("deposit"));//押金
		int isrenting=Integer.parseInt(request.getParameter("isrenting"));//租用情况
		String description=request.getParameter("description");;//简介
		
		bikesVo.setBikenumber(bikenumber);
		bikesVo.setBiketype(biketype);
		bikesVo.setColor(color);
		bikesVo.setPrice(price);
		bikesVo.setRentprice(rentprice);
		bikesVo.setDeposit(deposit);
		bikesVo.setIsrenting(isrenting);
		bikesVo.setDescription(description);
		
		AddBike addBike = new AddBike();
		addBike.addBike(bikesVo);//调用添加方法
		response.sendRedirect("ShowBikesServlet");//重定向到查询Servlet
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		
	}

}
