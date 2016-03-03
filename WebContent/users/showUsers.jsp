<%@ page language="java" import="com.cn.users.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h2 style="font-size: 20px;text-align: center;">�û���ѯ</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">
			<thead>

				<TR>
					<th>���</th>
					<th>��¼��</th>
					<th>���֤</th>
					<th>����</th>
					<th>�Ա�</th>
					<th>ְλ</th>
					<th>�û�����</th>
					<th>����</th>
				</TR>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="list">
				<TR>
					<TD>${list.id }</TD>
					<TD>${list.username }</TD>
					<TD>${list.identity }</TD>
					<TD>${list.fullname }</TD>
					<TD><c:if test="${list.sex ==1}">��</c:if> <c:if
								test="${list.sex ==0}">Ů</c:if></TD>
					<TD>${list.position }</TD>
					<TD><c:if test="${list.userlevel eq 'admin'}">����Ա</c:if> <c:if
								test="${list.userlevel eq 'service'}">������Ա</c:if> <c:if
								test="${list.userlevel eq 'user'}">��ͨ�ͻ�</c:if></TD>
					<TD><a href="ShowUserByIDServlet?id=${list.id }&code=show">�鿴</a>
						<a href="ShowUserByIDServlet?id=${list.id }&code=update">�޸�</a> 
						<a href="RentBikeServlet?userid=${list.id}&type=select">���ó���</a>
						<a href="DeleteUserServlet?id=${list.id }">ɾ��</a>
						</TD>
				</TR>
			</c:forEach>
			</tbody>
		</TABLE>
	</div>

</body>
</html>
