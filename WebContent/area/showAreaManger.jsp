<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="condiv">
		<h2 style="font-size: 20px;text-align: center;">区域详情</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>区域名：</TD>
	<TD>${areaVo.area }</TD>
</TR>
<TR>
	<TD>街道名：</TD>
	<TD>${areaVo.street }</TD>
</TR>
<TR>
	<TD>具体地址：</TD>
	<TD>${areaVo.address }</TD>
</TR>

<TR>
	<TD colspan="2" align="center"><button onClick="javascript:history.go(-1);" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="button" >返回</button></TD>
	
</TR>
</TABLE>
</div>

  </body>
</html>
