<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生管理</title>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/main.css">
</head>
<body onload="getTime()">
<header>
	<img alt="logo_image" src="<%=basePath%>/images/title.png"><span style="font-size: 1.5em;color: #fff;">山东XX大学</span>
    <span id="ManagerTitle">教学综合管理服务平台</span>
    <time id="gtime"  datetime="YYYY-MM-DDThh:mm:ss" style="float: right;margin-top: 10px;"></time>
    </header>
    <main">
        <img src="<%=basePath %>/images/bg.png" alt="插画" id="illustration"/>
        <form action="LoginServlet" method="POST">
            账号：<input type="text" name="account"/><br>
            密码：<input type="password" name="password"/><br>
            身份：<select name="type">
                	<option>学生</option>
                	<option>教师</option>
                	<option>管理员</option>
            	</select><br>
            <input type="submit" value="登录" style="width: 100%;"/>
        </form>
    </main> 
    <footer style="position: relative; top: 27vh;">
        <span id="usertab"></span>
        <span id="cc">GenticMemory.cc出品</span>
        <span id="time">2020-2021学年第二学期</span>
    </footer>
    <script type="text/javascript" src="<%=basePath %>/js/times.js"></script>
</body>
</html>