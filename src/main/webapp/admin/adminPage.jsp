<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员</title>
<%
String path = request.getContextPath();
String url = request.getRequestURI();
String[] a = url.split("/");
String ser = a[2].toString();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;


%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/main.css">
</head>
<body>
<header>
        <img alt="logo_image" src="<%=basePath%>/images/title.png"><span style="font-size: 1.5em;color: #fff;">山东XX大学</span>
        <span id="ManagerTitle">教学综合管理服务平台</span>
        <nav id="menu">
            <ul>
                <li><a href="<%=basePath %>/admin/adminPage.jsp">首页</a></li>
                <li><a href="#">主控</a></li>
                <li><a href="#">搜索</a></li>
                <li><a href="#" onclick="exit()">退出</a></li>
            </ul>
            <time id="gtime" datetime="YYYY-MM-DDThh:mm:ss" style="float: right;margin-top: 10px;"></time>
        </nav>
        </header>
        <main>
        <div id="left">
            <table id="message">
                <td class="bg"></td>
                <%
                	List<String> message = (List<String>)application.getAttribute("message");
                	if(message!=null){
                		for(String ms:message){
                %>
                <tr>
	              	<td><%=ms %></td>
                </tr>
                <%		}
                 	}%>
            </table>
            <table id="main_menu">
                <td class="bg"></td>
                <tr>
                    <td class="btn"><button onclick="getStudentRequest()">学生修改</button></td>
                </tr>
                <tr>
                    <td class="btn"><button onclick="getTeacherRequest()">教师修改</button></td>
                </tr>
                <tr>
                	<td class="btn"><button onclick="getCourseRequest()">课表修改</button></td>
                </tr>
                <tr>
                	<td class="btn"><button onclick="putMessage()">发布公告</button></td>
                </tr>
                <tr>
                	<td class="btn"><button onclick="getLog()">日志</button></td>
                </tr>
            </table>

                
        </div>
        <div id="right">
        	<table id="view" style="width: 100%;height: 100%;">
        	<%
        		
        		
        	%>
        	</table>
        </div>
        </main>
        <footer>
            <span id="usertab">${sessionScope.login_Tag.account}${sessionScope.login_Tag.name}</span>
            <span id="cc">GenticMemory.cc出品</span>
            <span id="time">2020-2021学年第二学期</span>
        </footer>
        <script type="text/javascript" src="<%=basePath %>/js/ajax.js"></script>
        <script type="text/javascript" src="<%=basePath %>/js/times.js"></script>
        <script type="text/javascript" src="<%=basePath %>/js/admin.js"></script>
</body>
</html>