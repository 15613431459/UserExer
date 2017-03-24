<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户角色列表</title>
</head>
<body>
	<div>
		<a href="/roles/showAddRole">添加用户角色</a>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CODE</th>
			<th>拥有权限</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${roleVos }" var="roleVo">
			<tr>
				<td>${roleVo.role.id }</td>
				<td>${roleVo.role.name }</td>
				<td>${roleVo.role.code }</td>
				<td>
					<c:forEach items="${roleVo.permissions }" var="permission">
						${permission.name }|
					</c:forEach>
				</td>
				<td><a href="/roles/showRole?id=${roleVo.role.id }">修改</a></td>
				<td><a href="/roles/deleteRole?id=${roleVo.role.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>