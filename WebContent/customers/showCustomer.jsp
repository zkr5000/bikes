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
<title>My JSP 'showUsers.jsp' starting page</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="base.css" />
<link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
</head>
<body style="background-color: whitesmoke">
	<div class="condiv">
		<h2 style="font-size: 20px;text-align: center;">�ͻ���ѯ</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">
			<thead>
<TR>
	<TD>��ţ�</TD>
	<TD>���֤��</TD>
	<TD>������</TD>
	<TD>�Ա�</TD>
	<TD>�绰��</TD>
	<TD>ְҵ��</TD>
	<TD>������</TD>
</TR>
</thead>
<tbody>
<c:forEach items="${ list}" var="list">
<TR>
	<TD>${list.id}</TD>
	<TD>${list.identity }</TD>
	<TD>${list.custname }</TD>
	<TD>
		<c:if test="${list.sex== 1}">��</c:if>
		<c:if test="${list.sex== 0}">Ů</c:if>
	</TD>
	<TD>${list.phone }</TD>
	<TD>${list.career }</TD>
	<TD>
		<a href="<%=basePath%>ShowCustomerByIdServlet?id=${list.id }&code=show">�鿴</a>
		<a href="<%=basePath%>ShowCustomerByIdServlet?id=${list.id }&code=update">�޸�</a>
		<a href="<%=basePath%>DeleteCustomerServlet?id=${list.id }">ɾ��</a>
	</TD>
</TR>
</c:forEach>
</tbody>
</TABLE>
</div>
  </body>
</html>
