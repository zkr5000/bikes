package com.cn.area;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddAreaServlet extends HttpServlet {

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
		AreaVo areaVo=new AreaVo();
		String area= request.getParameter("area");
		String street=request.getParameter("street");
		String address=request.getParameter("address");
		
		areaVo.setArea(area);
		areaVo.setStreet(street);
		areaVo.setAddress(address);
		
		
		AddArea addBike = new AddArea();
		addBike.addArea(areaVo);//调用添加方法
		response.sendRedirect("ShowAreaServlet");//重定向到查询Servlet
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		
	}

}
