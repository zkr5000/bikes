package com.cn.bike;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ShowBikesServlet extends HttpServlet {


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
		ShowBikes showBikes = new ShowBikes();
		List<BikesVo> list = new ArrayList<BikesVo>();
		String page1 = request.getParameter("page");//���ҳ�洫�ݹ�����pageֵ��ֵ��page1
		int page =1;
		if(page1 != null){
			page = Integer.parseInt(page1);//���ҳ�洫�ݹ�����pageֵ���ڣ���Ѹ�page1��ֵ��page����
		}
		list = showBikes.showByPage(page);//���ò�ѯ����
		int maxpage = showBikes.maxpage();//�������ҳ������
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		System.out.println(maxpage);
		request.getRequestDispatcher("bike/showBike.jsp").forward(request, response);//ת����ҳ��
		out.flush();
		out.close();
	}

}
