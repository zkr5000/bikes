<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String contextPath = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showBikeManger.jsp' starting page</title>
   <base href="<%=basePath%>">
<link rel="stylesheet" href="base.css" />
<link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
  </head>
  
<body style="background-color: whitesmoke">
    <form name="form" method="post" action="UpdateCustomerServlet">
    <input name="id" type="hidden" value="${vo.id }"/>
<div class="condiv">
		<h2 style="font-size: 20px;text-align: center;">客户信息修改</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>身份证：</TD>
	<TD><input name="identity" value="${vo.identity }"/></TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD><input name="custname" value="${vo.custname }"/></TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="${vo.sex}">
				<c:if test="${vo.sex==1}">男</c:if>
				<c:if test="${vo.sex==0}">女</c:if>
			</option>
			<option value="1">男</option>
			<option value="0">女</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<TD><input name="address" value="${vo.address }"/></TD>
</TR>
<TR>
	<TD>电话：</TD>
	<TD><input name="phone" value="${vo.phone }"/></TD>
</TR>
<TR>
	<TD>职业：</TD>
	<TD><input name="career" value="${vo.career }"/></TD>
</TR>
<TR>
	<TD>密码：</TD>
	<TD><input name="password" value="${vo.password }"/></TD>
</TR>
<TR>
	<TD colspan="2" align="center"><button  class="btn btn-primary btn-block btn-flat" style="width: 300px" type="submit" >提交</button></TD>
	
</TR>
</TABLE>
</div>
</form>
  </body>
</html>
