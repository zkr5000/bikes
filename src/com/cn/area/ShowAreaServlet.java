package com.cn.area;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ShowAreaServlet extends HttpServlet {


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
		ShowArea showBikes = new ShowArea();
		List<AreaVo> list = new ArrayList<AreaVo>();
		
		list = showBikes.showArea();//调用查询方法
		request.setAttribute("list", list);
		request.getRequestDispatcher("area/showArea.jsp").forward(request, response);//转发到页面
		out.flush();
		out.close();
	}

}
