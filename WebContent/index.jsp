<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	
  </head>
  
  <body>
   	<a href="<%=basePath%>user/getAllUser">进入用户管理页</a></h5>
   	<a href="<%=basePath%>admin/adminIndex">管理员界面</a></h5>
    <a href="<%=basePath%>upload.jsp">上传</a></h5>
  </body>
</html>
