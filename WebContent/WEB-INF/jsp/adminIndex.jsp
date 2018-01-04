<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <title>管理员界面</title>
    
	<script type="text/javascript">
		function information(id){
			  $.ajax({
		             type: "POST",
		             url: "<%=basePath%>admin/getUserInfoById",
		             data: {id:id},
		             //dataType: "json",
		             success: function(data){
		                         alert(data);
		                      }
		         });
		}
   </script>
  </head>
  
  <body>
  <center>
  	<h1>管理员界面</h1>
	<table border="1" width="100%">
		<tbody>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty userList }">
				<c:forEach items="${userList}" var="user">
					<tr>
						<td style="text-align:center;">${user.userName }</td>
						<td style="text-align:center;">${user.age }</td>
						<td style="text-align:center;">
							<a href="<%=basePath%>user/getUser?id=${user.id}">编辑</a>
							<a href="javascript:del('${user.id }')">删除</a>
							<a href="javascript:information('${user.id }')">详细信息</a>
						</td>
					</tr>				
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<h6><a href="<%=basePath%>user/toAddUser">添加用户</a></h6>
  </center>
  </body>
</html>
