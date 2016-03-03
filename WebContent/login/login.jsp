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
<title>My JSP 'login.jsp' starting page</title>
<base href="<%=basePath%>">
<link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="base.css" />
<link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jQuery-2.1.4.min.js"></script>
<script type="text/javascript">
	function check() {
		if (document.getElementById("username").value.length == 0) {
			alert("用户名不能为空！");
			return false;
		} else if (document.getElementById("password").value.length == 0) {
			alert("密码不能为空！");
			return false;
		}
		$("#logFrm").submit();
		return true;
		
	}
</script>
</head>
 <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="../../index2.html"><b>后台管理登录</b></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">请输入您的登录信息</p>
        <form action="LoginServlet" id="logFrm" method="post">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="用户名" name="username" id="username" />
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="密码" name="password" id="password" />
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                 
                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button onclick="check()" type="button" class="btn btn-primary btn-block btn-flat">登录</button>
            </div><!-- /.col -->
          </div>
        </form>

       
      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

  </body>

</html>
