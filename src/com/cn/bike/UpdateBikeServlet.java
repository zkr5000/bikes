package com.cn.bike;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateBikeServlet extends HttpServlet {


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);//调用doPost方法
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		int id = Integer.parseInt(request.getParameter("id"));
		String bikenumber= request.getParameter("bikenumber");//车号
		String biketype=request.getParameter("biketype");//型号
		String color=request.getParameter("color");//颜色
		double price=Double.parseDouble(request.getParameter("price"));//价值
		double rentprice=Double.parseDouble(request.getParameter("rentprice"));//租金
		double deposit=Double.parseDouble(request.getParameter("deposit"));//押金
		int isrenting=Integer.parseInt(request.getParameter("isrenting"));//租用情况
		String description=request.getParameter("description");//简介
		BikesVo bikesVo = new BikesVo();
		//把页面数据设置到carsVo对象中
		bikesVo.setId(id);
		bikesVo.setColor(color);
		bikesVo.setBikenumber(bikenumber);
		bikesVo.setBiketype(biketype);
		bikesVo.setPrice(price);
		bikesVo.setRentprice(rentprice);
		bikesVo.setDeposit(deposit);
		bikesVo.setIsrenting(isrenting);
		bikesVo.setDescription(description);
		UpdateBike updateBike = new UpdateBike();
		updateBike.updatebike(bikesVo);//调用修改方法
		//重定向到显示全部的页面
		response.sendRedirect("ShowBikesServlet");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
