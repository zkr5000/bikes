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
		this.doPost(request, response);//����doPost����
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		int id = Integer.parseInt(request.getParameter("id"));
		String area= request.getParameter("area");//����
		String address=request.getParameter("address");//�ͺ�
		String street=request.getParameter("street");//��ɫ
		
		AreaVo bikesVo = new AreaVo();
		//��ҳ���������õ�carsVo������
		bikesVo.setId(id);
		bikesVo.setArea(area);
		bikesVo.setAddress(address);
		bikesVo.setStreet(street);
		
		UpdateArea updateBike = new UpdateArea();
		updateBike.updatearea(bikesVo);//�����޸ķ���
		//�ض�����ʾȫ����ҳ��
		response.sendRedirect("ShowAreaServlet");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
