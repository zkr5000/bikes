package com.cn.area;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ShowAreaBikeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);//����doPost����
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ShowArea showBikes = new ShowArea();
		List<AreaBikeVo> list = new ArrayList<AreaBikeVo>();
		
		list = showBikes.showBikeArea();//���ò�ѯ����
		request.setAttribute("list", list);
		request.getRequestDispatcher("area/showAreaBike.jsp").forward(request, response);//ת����ҳ��
		out.flush();
		out.close();
	}

}
