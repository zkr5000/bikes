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
    <form name="form" action="UpdateUserServlet" method="post">
    <input type="hidden" name="id" value="${usersVo.id }" />
<div class="condiv">
		<h2 style="font-size: 20px;text-align: center;">���г���Ϣ�޸�</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">
<TR>
	<TD>��¼����</TD>
	<TD><input name="username" value="${usersVo.username }"/></TD>
</TR>
<TR>
	<TD>���֤��</TD>
	<TD><input name="identity" value="${usersVo.identity }"/></TD>
</TR>
<TR>
	<TD>������</TD>
	<TD><input name="fullname" value="${usersVo.fullname }"/></TD>
</TR>
<TR>
	<TD>�Ա�</TD>
	<TD>
		<SELECT name="sex" id="sex">
			<option value="${usersVo.sex}">
				<c:if test="${usersVo.sex ==1}">�� </c:if>
				<c:if test="${usersVo.sex ==0}">Ů </c:if>
			</option>
			<option value="1">��</option>
			<option value="0">Ů</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>��ַ��</TD>
	<td><input name="address" value="${usersVo.address }"/></td>
</TR>
<TR>
	<TD>��ϵ�绰��</TD>
	<TD><input name="phone" value="${usersVo.phone }"/></TD>
</TR>
<TR>
	<TD>ְλ��</TD>
	<TD><input name="position" value="${usersVo.position }"/></TD>
</TR>
<TR>
	<TD>�û����ͣ�</TD>
	<TD>
		<SELECT name="userlevel" id="role">
			<option value="${usersVo.userlevel}">
				<c:if test="${usersVo.userlevel eq 'admin'}">����Ա</c:if>
				<c:if test="${usersVo.userlevel eq 'service'}">������Ա</c:if>
				<c:if test="${usersVo.userlevel eq 'user'}">��ͨ�ͻ�</c:if>
			</option>
			<option value="admin">����Ա</option>
			<option value="service">������Ա</option>
			<option value="user">��ͨ�ͻ�</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD colspan="2" align="center"><button  class="btn btn-primary btn-block btn-flat" style="width: 300px" type="submit" >�ύ</button></TD>
	
</TR>
</TABLE>
</div>
</form>
  </body>
</html>
