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
			document.getElementById("username1").innerHTML="身份证不能为空！";
			return false;
		}else if(document.getElementById("identity").value.length ==0 ){
			document.getElementById("identity1").innerHTML="姓名不能为空！";
			return false;
		}else if(document.getElementById("userlevel").value.length ==0 ){
			document.getElementById("userlevel1").innerHTML="用户类型不能为空！";
			return false;
		}else if(document.getElementById("password").value.length ==0 ){
			document.getElementById("password1").innerHTML="密码不能为空！";
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
		<h2 style="font-size: 20px;text-align: center;">自行车添加</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">
<TR>
	<TD>登录名：</TD>
	<TD><input name="username" id="username"/><span id="username1"></span></TD>
</TR>
<TR>
	<TD>身份证：</TD>
	<TD><input name="identity" id="identity"/><span id="identity1"></span></TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD><input name="fullname"/></TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="1">男</option>
			<option value="0">女</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<td><input name="address"/></td>
</TR>
<TR>
	<TD>联系电话：</TD>
	<TD><input name="phone"/></TD>
</TR>
<TR>
	<TD>职位：</TD>
	<TD><input name="position"/></TD>
</TR>
<TR>
	<TD>用户类型：</TD>
	<TD>
		<SELECT id="role" name="userlevel">
			<option>请选择</option>
			<option value="admin">管理员</option>
			<option value="service">服务人员</option>
			<option value="user">普通客户</option>
		</SELECT><span id="userlevel1"></span>
	</TD>
</TR>
<TR>
	<TD>用户密码：</TD>
	<td><input type="password" name="password"/><span id="password1"></span></td>
</TR>
<TR>
	<TD colspan="2" align="center"><button onclick="check()" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="submit" >提交</button></TD>

</TR>
</TABLE>
</div>
</form>
  </body>
</html>
