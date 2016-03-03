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
		String bikenumber= request.getParameter("bikenumber");//����
		String biketype=request.getParameter("biketype");//�ͺ�
		String color=request.getParameter("color");//��ɫ
		double price=Double.parseDouble(request.getParameter("price"));//��ֵ
		double rentprice=Double.parseDouble(request.getParameter("rentprice"));//���
		double deposit=Double.parseDouble(request.getParameter("deposit"));//Ѻ��
		int isrenting=Integer.parseInt(request.getParameter("isrenting"));//�������
		String description=request.getParameter("description");;//���
		
		bikesVo.setBikenumber(bikenumber);
		bikesVo.setBiketype(biketype);
		bikesVo.setColor(color);
		bikesVo.setPrice(price);
		bikesVo.setRentprice(rentprice);
		bikesVo.setDeposit(deposit);
		bikesVo.setIsrenting(isrenting);
		bikesVo.setDescription(description);
		
		AddBike addBike = new AddBike();
		addBike.addBike(bikesVo);//������ӷ���
		response.sendRedirect("ShowBikesServlet");//�ض��򵽲�ѯServlet
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		
	}

}
