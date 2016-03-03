package com.cn.area;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateAreaServlet extends HttpServlet {


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
		String area= request.getParameter("area");//车号
		String address=request.getParameter("address");//型号
		String street=request.getParameter("street");//颜色
		
		AreaVo bikesVo = new AreaVo();
		//把页面数据设置到carsVo对象中
		bikesVo.setId(id);
		bikesVo.setArea(area);
		bikesVo.setAddress(address);
		bikesVo.setStreet(street);
		
		UpdateArea updateBike = new UpdateArea();
		updateBike.updatearea(bikesVo);//调用修改方法
		//重定向到显示全部的页面
		response.sendRedirect("ShowAreaServlet");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
