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
		<h2 style="font-size: 20px;text-align: center;">�ͻ���Ϣ�޸�</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>���֤��</TD>
	<TD><input name="identity" value="${vo.identity }"/></TD>
</TR>
<TR>
	<TD>������</TD>
	<TD><input name="custname" value="${vo.custname }"/></TD>
</TR>
<TR>
	<TD>�Ա�</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="${vo.sex}">
				<c:if test="${vo.sex==1}">��</c:if>
				<c:if test="${vo.sex==0}">Ů</c:if>
			</option>
			<option value="1">��</option>
			<option value="0">Ů</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>��ַ��</TD>
	<TD><input name="address" value="${vo.address }"/></TD>
</TR>
<TR>
	<TD>�绰��</TD>
	<TD><input name="phone" value="${vo.phone }"/></TD>
</TR>
<TR>
	<TD>ְҵ��</TD>
	<TD><input name="career" value="${vo.career }"/></TD>
</TR>
<TR>
	<TD>���룺</TD>
	<TD><input name="password" value="${vo.password }"/></TD>
</TR>
<TR>
	<TD colspan="2" align="center"><button  class="btn btn-primary btn-block btn-flat" style="width: 300px" type="submit" >�ύ</button></TD>
	
</TR>
</TABLE>
</div>
</form>
  </body>
</html>
