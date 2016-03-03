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
		this.doPost(request, response);//����doPost����
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		int id = Integer.parseInt(request.getParameter("id"));
		String bikenumber= request.getParameter("bikenumber");//����
		String biketype=request.getParameter("biketype");//�ͺ�
		String color=request.getParameter("color");//��ɫ
		double price=Double.parseDouble(request.getParameter("price"));//��ֵ
		double rentprice=Double.parseDouble(request.getParameter("rentprice"));//���
		double deposit=Double.parseDouble(request.getParameter("deposit"));//Ѻ��
		int isrenting=Integer.parseInt(request.getParameter("isrenting"));//�������
		String description=request.getParameter("description");//���
		BikesVo bikesVo = new BikesVo();
		//��ҳ���������õ�carsVo������
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
		updateBike.updatebike(bikesVo);//�����޸ķ���
		//�ض�����ʾȫ����ҳ��
		response.sendRedirect("ShowBikesServlet");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
