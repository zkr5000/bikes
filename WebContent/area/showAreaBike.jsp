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
		<h2 style="font-size: 20px;text-align: center;">车辆区域查询</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">
			<thead>
<TR>
	<th>区名</th>
	<th>街道名</th>
	<th>具体地址</th>
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
	<TD>${list.area}</TD>
	<TD>${list.street}</TD>
	<TD>${list.address}</TD>
	<TD>${list.bikenumber}</TD>
	<TD>${list.biketype}</TD>
	<TD>${list.color }</TD>
	<TD>${list.price }</TD>
	<TD>${list.rentprice }</TD>
	<TD>${list.deposit }</TD>
	<TD>
	<a href="<%=basePath%>DeleteAreaBikeServet?id=${list.id }">删除</a></TD>
</TR>
</c:forEach>
</tbody>
</TABLE>
</div>
  </body>
</html>
