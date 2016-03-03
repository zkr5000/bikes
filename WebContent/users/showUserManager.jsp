<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    <title>My JSP 'showBike.jsp' starting page</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="base.css" />
<link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
  </head>
<body style="background-color: whitesmoke">
	<div class="condiv">
		<h2 style="font-size: 20px;text-align: center;">用户详情</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>登录名：</TD>
	<TD>${usersVo.username }</TD>
</TR>
<TR>
	<TD>身份证：</TD>
	<TD>${usersVo.identity }</TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD>${usersVo.fullname }</TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
				<c:if test="${usersVo.sex ==1}">男 </c:if>
				<c:if test="${usersVo.sex ==0}">女 </c:if>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<td>${usersVo.address }</td>
</TR>
<TR>
	<TD>联系电话：</TD>
	<TD>${usersVo.phone }</TD>
</TR>
<TR>
	<TD>职位：</TD>
	<TD>${usersVo.position }</TD>
</TR>
<TR>
	<TD>用户类型：</TD>
	<TD>
				<c:if test="${usersVo.userlevel eq 'admin'}">管理员</c:if>
				<c:if test="${usersVo.userlevel eq 'service'}">服务人员</c:if>
				<c:if test="${usersVo.userlevel eq 'user'}">普通客户</c:if>
	</TD>
</TR>
<TR>
	<TD>用户密码：</TD>
	<td>${usersVo.password }</td>
</TR>
<TR>
	<TD colspan="2" align="center"><button onClick="javascript:history.go(-1);" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="button" >返回</button></TD>
	
</TR>
</TABLE>
</div>
  </body>
</html>
