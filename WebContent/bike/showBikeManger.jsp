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
		<h2 style="font-size: 20px;text-align: center;">���г�����</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>���ţ�</TD>
	<TD>${bikesVo.bikenumber }</TD>
</TR>
<TR>
	<TD>�ͺţ�</TD>
	<TD>${bikesVo.biketype }</TD>
</TR>
<TR>
	<TD>��ɫ��</TD>
	<TD>${bikesVo.color }</TD>
</TR>
<TR>
	<TD>��ֵ��</TD>
	<TD>${bikesVo.price }</TD>
</TR>
<TR>
	<TD>���</TD>
	<TD>${bikesVo.rentprice }</TD>
</TR>
<TR>
	<TD>Ѻ��</TD>
	<TD>${bikesVo.deposit }</TD>
</TR>
<TR>
	<TD>���������</TD>
	<TD>
		<c:if test="${bikesVo.isrenting == 1 }">�ѳ���</c:if>
		<c:if test="${bikesVo.isrenting == 0 }">δ����</c:if>
	</TD>
</TR>
<TR>
	<TD colspan="2" align="center"><button onClick="javascript:history.go(-1);" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="button" >����</button></TD>
	
</TR>
</TABLE>
</div>

  </body>
</html>
