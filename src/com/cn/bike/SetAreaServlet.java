package com.cn.bike;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.area.AreaVo;
import com.cn.area.ShowArea;



public class SetAreaServlet extends HttpServlet {


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
		List<AreaVo> list = new ArrayList<AreaVo>();
		
		list = showBikes.showArea();//���ò�ѯ����
		ShowBikes bikes=new ShowBikes();
		String bikeid=request.getParameter("bikeid");
		String type=request.getParameter("type");
		request.setAttribute("list", list);
		request.setAttribute("bikeid", bikeid);
		if("select".equals(type)){
			request.getRequestDispatcher("bike/setBikeArea.jsp").forward(request, response);//ת����ҳ��
		}else if("set".equals(type)){
			String id=request.getParameter("id");
			bikes.setBikeArea(id, bikeid);
			response.sendRedirect("ShowAreaBikeServlet");
		}
		
		out.flush();
		out.close();
	}

}
