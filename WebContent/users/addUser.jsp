<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
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
    <title>My JSP 'addUser.jsp' starting page</title>
    <base href="<%=basePath%>">
<link rel="stylesheet" href="base.css" />
<link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
	<link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jQuery-2.1.4.min.js"></script>
    
     <script type="text/javascript">
  	function check(){
  		if(document.getElementById("username").value.length ==0 ){
			document.getElementById("username1").innerHTML="���֤����Ϊ�գ�";
			return false;
		}else if(document.getElementById("identity").value.length ==0 ){
			document.getElementById("identity1").innerHTML="��������Ϊ�գ�";
			return false;
		}else if(document.getElementById("userlevel").value.length ==0 ){
			document.getElementById("userlevel1").innerHTML="�û����Ͳ���Ϊ�գ�";
			return false;
		}else if(document.getElementById("password").value.length ==0 ){
			document.getElementById("password1").innerHTML="���벻��Ϊ�գ�";
			return false;
		}
  		$("#form").submit();
		return true;
  	}
  </script>
  </head>
  <body>
    <form name="form" action="AddUserServlet" method="post" >
<div class="condiv" style="min-height: 550px">
		<h2 style="font-size: 20px;text-align: center;">���г����</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">
<TR>
	<TD>��¼����</TD>
	<TD><input name="username" id="username"/><span id="username1"></span></TD>
</TR>
<TR>
	<TD>���֤��</TD>
	<TD><input name="identity" id="identity"/><span id="identity1"></span></TD>
</TR>
<TR>
	<TD>������</TD>
	<TD><input name="fullname"/></TD>
</TR>
<TR>
	<TD>�Ա�</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="1">��</option>
			<option value="0">Ů</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>��ַ��</TD>
	<td><input name="address"/></td>
</TR>
<TR>
	<TD>��ϵ�绰��</TD>
	<TD><input name="phone"/></TD>
</TR>
<TR>
	<TD>ְλ��</TD>
	<TD><input name="position"/></TD>
</TR>
<TR>
	<TD>�û����ͣ�</TD>
	<TD>
		<SELECT id="role" name="userlevel">
			<option>��ѡ��</option>
			<option value="admin">����Ա</option>
			<option value="service">������Ա</option>
			<option value="user">��ͨ�ͻ�</option>
		</SELECT><span id="userlevel1"></span>
	</TD>
</TR>
<TR>
	<TD>�û����룺</TD>
	<td><input type="password" name="password"/><span id="password1"></span></td>
</TR>
<TR>
	<TD colspan="2" align="center"><button onclick="check()" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="submit" >�ύ</button></TD>

</TR>
</TABLE>
</div>
</form>
  </body>
</html>
