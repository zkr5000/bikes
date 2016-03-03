package com.cn.bike;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class QueryByIdServlet extends HttpServlet {


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
		int id = Integer.parseInt(request.getParameter("id"));//���ҳ�洫�ݹ�����ID
		String code =request.getParameter("code");//����������е�code
		BikesVo bikesVo = new BikesVo();
		QueryById byId = new QueryById();
		bikesVo = byId.queryById(id);//���ò�ѯ����
		request.setAttribute("bikesVo", bikesVo);//�Ѳ�ѯ�������ݷ���request��
		if(code.equals("update")){//�жϵ��յ�ֵΪupdateʱ��ת�����޸�ҳ��
			request.getRequestDispatcher("bike/updateBike.jsp").forward(request, response);
		}else if(code.equals("select")){//�жϵ�codeֵΪcelectʱ��ת������ʾ������Ϣҳ��
			request.getRequestDispatcher("bike/showBikeManger.jsp").forward(request, response);
		}
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
