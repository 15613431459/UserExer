<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户权限列表</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CODE</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${permissions }" var="p">
			<tr>
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>${p.code }</td>
				<td><a href="/permission/toUpdatePermission?id=${p.id }">修改</a></td>
				<td><a href="/permission/deletePermission?id=${p.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/permission/addPermission">新增</a>
	
</body>
</html>