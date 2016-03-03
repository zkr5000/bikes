package com.cn.bike;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RentBikesServlet extends HttpServlet {


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
		ShowBikes showBikes = new ShowBikes();
		List<BikesVo> list = new ArrayList<BikesVo>();
		String userid=request.getParameter("userid");
		String type=request.getParameter("type");
		list = showBikes.showBikes();//调用查询方法
		request.setAttribute("list", list);
		request.setAttribute("userid", userid);
		if("select".equals(type)){
			request.getRequestDispatcher("bike/rentBike.jsp").forward(request, response);//转发到页面
		}else if("rent".equals(type)){
			String id=request.getParameter("id");
			showBikes.rentBike(id, userid);
			response.sendRedirect("ShowBikeUserServlet");
		}
		
		out.flush();
		out.close();
	}

}
