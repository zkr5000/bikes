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
    <title>My JSP 'addBike.jsp' starting page</title>
    <base href="<%=basePath%>">
<link rel="stylesheet" href="base.css" />
<link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
	<link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jQuery-2.1.4.min.js"></script>
  </head>
<body style="background-color: whitesmoke">
  <script type="text/javascript">
  	function check(){
  		if(document.getElementById("area").value.length ==0 ){
			document.getElementById("areaSpn").innerHTML="自行车号不能为空！";
			return false;
		}else if(document.getElementById("street").value.length ==0 ){
			document.getElementById("streetSpn").innerHTML="型号不能为空！";
			return false;
		}else if(document.getElementById("price").value.length ==0 ){
			document.getElementById("addressSpn").innerHTML="价值不能为空！";
			return false;
		}
		$("#form").submit();
			return true;
		
  	}
  </script>
    <form name="form" method="post" action="AddAreaServlet" >
<div class="condiv" style="min-height: 550px">
		<h2 style="font-size: 20px;text-align: center;">区域添加</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>区名：</TD>
	<TD><input name="area" id="area"/><span id="areaSpn"></span></TD>
</TR>
<TR>
	<TD>街道名：</TD>
	<TD><input name="street" id="street"/><span id="streetSpn"></span></TD>
</TR>
<TR>
	<TD>具体地址：</TD>
	<TD><input name="address" id="address"/><span id="addressSpn"></span></TD>
</TR>

<TR>
	<TD colspan="2" align="center"><button onclick="check()" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="submit" >提交</button></TD>
</TR>
</TABLE>
</div>
</form>
  </body>
</html>
