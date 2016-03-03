<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<h2 style="font-size: 20px;text-align: center;">用户租用车辆查询</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">
			<thead>
<TR>
	<th>用户名</th>
	<th>租用车号</th>
	<th>车辆类型</th>
	<th>颜色</th>
	<th>价值</th>
	<th>租金</th>
	<th>押金</th>
	<th>操作</th>
</TR>
</thead>
<tbody>
<c:forEach items="${list}" var="list">
<TR>
	<TD>${list.username}</TD>
	<TD>${list.bikenumber}</TD>
	<TD>${list.biketype}</TD>
	<TD>${list.color }</TD>
	<TD>${list.price }</TD>
	<TD>${list.rentprice }</TD>
	<TD>${list.deposit }</TD>
	<TD>
	<a href="<%=basePath%>DeleteBikeUserServet?id=${list.id }">删除</a></TD>
</TR>
</c:forEach>
</tbody>
</TABLE>
</div>
  </body>
</html>
