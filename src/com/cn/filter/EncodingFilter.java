package com.cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//������request�ڵĶ��������ַ���Ϊgb2312 
		request.setCharacterEncoding("gb2312");
		//������response�ڵĶ��������ַ���Ϊgb2312
	    response.setCharacterEncoding("gb2312");
		//��chain��doFilter������� 
	    chain.doFilter(request, response); 
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
