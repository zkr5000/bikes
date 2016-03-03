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
  		if(document.getElementById("bikenumber").value.length ==0 ){
			document.getElementById("num").innerHTML="自行车号不能为空！";
			return false;
		}else if(document.getElementById("biketype").value.length ==0 ){
			document.getElementById("biketype1").innerHTML="型号不能为空！";
			return false;
		}else if(document.getElementById("price").value.length ==0 ){
			document.getElementById("price1").innerHTML="价值不能为空！";
			return false;
		}else if(document.getElementById("rentprice").value.length ==0 ){
			document.getElementById("rentprice1").innerHTML="租金不能为空！";
			return false;
		}else if(document.getElementById("deposit").value.length ==0 ){
			document.getElementById("deposit1").innerHTML="押金不能为空！";
			return false;
		}
		$("#form").submit();
			return true;
		
  	}
  </script>
    <form name="form" method="post" action="AddBikeServlet" >
<div class="condiv" style="min-height: 550px">
		<h2 style="font-size: 20px;text-align: center;">自行车添加</h2>
		<TABLE align="center"
			class="table table-bordered table-striped dataTable">

<TR>
	<TD>车号：</TD>
	<TD><input name="bikenumber" id="bikenumber"/><span id="num"></span></TD>
</TR>
<TR>
	<TD>型号：</TD>
	<TD><input name="biketype" id="biketype"/><span id="biketype1"></span></TD>
</TR>
<TR>
	<TD>颜色：</TD>
	<TD><input name="color" id="color"/></TD>
</TR>
<TR>
	<TD>价值：</TD>
	<TD><input name="price" id="price"/><span id="price1"></span></TD>
</TR>
<TR>
	<TD>租金：</TD>
	<TD><input name="rentprice" id="rentprice"/><span id="rentprice1"></span></TD>
</TR>
<TR>
	<TD>押金：</TD>
	<TD><input name="deposit" id="deposit"/></TD><span id="deposit1"></span>
</TR>
<TR>
	<TD>租用情况：</TD>
	<TD>
		<SELECT name="isrenting" id="isrenting">
			<option value="1">已出租</option>
			<option value="0">未出租</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>简介：</TD>
	<TD><textarea col="15" row="5" name="description" id="description"></textarea></TD>
</TR>
<TR>
	<TD colspan="2" align="center"><button onclick="check()" class="btn btn-primary btn-block btn-flat" style="width: 300px" type="submit" >提交</button></TD>
</TR>
</TABLE>
</div>
</form>
  </body>
</html>
