<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>

	<h1>读取所有表单参数</h1>

	<table width="100%" border="1" align="center">
	
		<tr bgcolor="#949494">
			<th>用户id</th>
			<th>用户姓名</th>
			<th>用户账号</th>
			<th>用户密码</th>
			<th>用户角色</th>
			<th>用户权限</th>
		</tr>
		
		<tr bgcolor="#949494">
			<td>${userVo.id}</td>
			<td>${userVo.name}</td>
			<td>${userVo.loginName}</td>
			<td>${userVo.password}</td>
			<td>
			<c:forEach items="${user.roleList}"  var="role" >
			${role.name}<br>
			</c:forEach>
			</td>
			<td>
			<c:forEach items="${userVo.permissionList}"  var="permission" >
			${permission.name}<br>
			</c:forEach>
			</td>
		</tr>
		
	</table>

</body>
</html>