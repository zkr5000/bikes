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
<title>管理界面</title>
<base href="<%=basePath%>">
<meta http-equiv="content-type" content="text/html; charset=GB2312" />

</head>
<frameset rows="100,*" frameborder="no" scrolling="NO" noresize="noresize">
    <frame src="header.html" scrolling="NO" name="top" noresize="noresize"/>
    <frameset rows="*,80" frameborder="no">
        <frameset cols="200,*" frameborder="no">
            <frame src="adm_menu.jsp" name="left" noresize="noresize"/>
            <frame src="welcome.html" name="right" noresize="noresize"/>
        </frameset>
        <frame src="footer.html" name="down" noresize="noresize"/>
    </frameset>
</frameset>
</html>