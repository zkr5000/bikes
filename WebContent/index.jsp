<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���г����޹���ϵͳ</title>
<base href="<%=basePath%>">
<meta http-equiv="content-type" content="text/html; charset=GB2312" />
<script>
	function submitForm() {

		var obj = document.getElementById("role");
		if (obj.value == "admin")
			document.location.href = "adm_index.jsp";
		else if (obj.value == "service")
			document.location.href = "ser_index.jsp";
		else
			document.location.href = "user_index.jsp";
	}
</script>
</head>
<body>
	<form name="form" method="post">
		<TABLE align="center">
			<TR>
				<TD>�û�����</TD>
				<TD><input name="userName" /></TD>
			</TR>
			<TR>
				<TD>���룺</TD>
				<TD><input name="pwd" /></TD>
			</TR>
			<TR>
				<TD>�û����ͣ�</TD>
				<TD><SELECT NAME="role" id="role">
						<option value="admin">����Ա</option>
						<option value="service">������Ա</option>
						<option value="user">��ͨ�ͻ�</option>
				</SELECT></TD>
			</TR>
			<TR>
				<td>
				<td>
				<TD><img src="images/submitOK.gif" onclick="submitForm()" /></TD>
			</TR>
		</TABLE>
	</form>
</body>
</html>