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
		<h2 style="font-size: 20px;text-align: center;">�û�����</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>��¼����</TD>
	<TD>${usersVo.username }</TD>
</TR>
<TR>
	<TD>���֤��</TD>
	<TD>${usersVo.identity }</TD>
</TR>
<TR>
	<TD>������</TD>
	<TD>${usersVo.fullname }</TD>
</TR>
<TR>
	<TD>�Ա�</TD>
	<TD>
				<c:if test="${usersVo.sex ==1}">�� </c:if>
				<c:if test="${usersVo.sex ==0}">Ů </c:if>
	</TD>
</TR>
<TR>
	<TD>��ַ��</TD>
	<td>${usersVo.address }</td>
</TR>
<TR>
	<TD>��ϵ�绰��</TD>
	<TD>${usersVo.phone }</TD>
</TR>
<TR>
	<TD>ְλ��</TD>
	<TD>${usersVo.position }</TD>
</TR>
<TR>
	<TD>�û����ͣ�</TD>
	<TD>
				<c:if test="${usersVo.userlevel eq 'admin'}">����Ա</c:if>
				<c:if test="${usersVo.userlevel eq 'service'}">������Ա</c:if>
				<c:if test="${usersVo.userlevel eq 'user'}">��ͨ�ͻ�</c:if>
	</TD>
</TR>
<TR>
	<TD>�û����룺</TD>
	<td>${usersVo.password }</td>
</TR>
<TR>
	<TD colspan="2" align="center"><button onClick="javascript:history.go(-1);" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="button" >����</button></TD>
	
</TR>
</TABLE>
</div>
  </body>
</html>
