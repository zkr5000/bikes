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
<title>自行车租赁管理系统</title>
<base href="<%=basePath%>">
<meta http-equiv="content-type" content="text/html; charset=GB2312" />
<SCRIPT language=javascript>
        function selectbox(indexbox)
        {
            parent.right.location.href = indexbox;
        }
    </SCRIPT>
    <SCRIPT language=javascript src="js/dtree/dtree.js"></SCRIPT>
    <script type="text/javascript" src="js/java-like.util.js"></script>
    <link rel="stylesheet" href="js/dtree/dtree.css" type="text/css">
    <link rel="stylesheet" href="base.css"/>
</head>
<body style="background-color: whitesmoke;padding-left: 10px;">
	<form action="" name="form1" method=POST>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td rowspan="5" width="1" bgcolor="CCCCCC"></td>
            <td bgcolor="CCCCCC" height="1"></td>
            <td rowspan="4" bgcolor="CCCCCC" width="1"></td>
        </tr>

        <tr>
            <td bgcolor="E3E7FF" align="center" height="5"></td>
        </tr>

        <tr>
            <td bgcolor="CCCCCC" height="1"></td>
        </tr>

        <tr style="height: 400px;">
            <td bgcolor="F9F9F9" align="center" valign="top">
                <table width="90%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="F5F5F5">
                    <tr bgcolor="F3F9FF">
                        <td bgcolor="F5F5F5" style="height: 380px;vertical-align: top;padding-top: 10px;">
                            <SCRIPT LANGUAGE="JavaScript">
                                d = new dTree('d');
                                d.config.target = "right";
                                d.config.imageDir = 'js/dtree/img';
                                d.reSetImagePath();
                                var isOpen ;
                                //根节点
                                d.add(0, -1, '自行车租赁管理系统');
                                d.add(1, 0, '用户管理','<%=basePath%>ShowUsersServlet', '', 'right','',true,true);
                                d.add(2, 0, '客户管理','<%=basePath%>ShowAllCustomerServlet', '', 'right','',true,true);
								d.add(3, 0, '自行车管理','<%=basePath%>ShowBikesServlet', '', 'right','',true,true);
								d.add(4, 0, '自行车管理','<%=basePath%>ShowBikeUserServlet', '', 'right','',true,true);
								d.add(5, 0, '区域管理','<%=basePath%>ShowAreaServlet', '', 'right','',true,true);
								d.add(6, 0, '车辆区域管理','<%=basePath%>ShowAreaBikeServlet', '', 'right','',true,true);
                               

                                d.add(7, 1, '添加用户', '<%=basePath%>users/addUser.jsp', '', 'right');
                                d.add(8, 1, '查询用户', '<%=basePath%>ShowUsersServlet', '', 'right');

                                d.add(9, 2, '添加客户信息', '<%=basePath%>customers/addCustomer.jsp', '', 'right');
                                d.add(10, 2, '查询客户信息', '<%=basePath%>ShowAllCustomerServlet', '', 'right');

								d.add(11, 3, '添加自行车信息', '<%=basePath%>bike/addBike.jsp', '', 'right');
								d.add(12, 3, '查询自行车信息', '<%=basePath%>ShowBikesServlet', '', 'right');
								
								d.add(13, 4, '查询租用信息', '<%=basePath%>ShowBikeUserServlet', '', 'right');
								
								d.add(14, 5, '添加区域', '<%=basePath%>area/addArea.jsp', '', 'right');
								d.add(15, 5, '查询区域信息', '<%=basePath%>ShowAreaServlet', '', 'right');
								
								d.add(16, 6, '查询车辆区域信息', '<%=basePath%>ShowAreaBikeServlet', '', 'right');
                                document.write(d);
                            </script>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr>
            <td background="images/jao1.gif" colspan="2" align="right"><img
                    src="images/jao.gif" width="8" height="8"></td>
        </tr>

    </table>
</form>
</body>
</html>