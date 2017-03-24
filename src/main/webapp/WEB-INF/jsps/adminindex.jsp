<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理员</title>
</head>
<body>
	<div class="btn-group col-md-10 col-md-offset-1" role="group">
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a href="/permission/findAllPermission">权限</a></li>
			<li role="presentation"><a href="/roles/findAllRole">角色</a></li>
			<li role="presentation"><a href="/user/addUser">添加用户</a></li>
		</ul>
	</div>
	<div><br></div>
	<div class="col-md-10 col-md-offset-1">
		<table class="table table-striped">
			<tr>
				<td>编号</td>
				<td>登陆名</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>角色</td>
				<td>权限</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${userVoList}" var="uservo">
				<tr>
					<c:set value="${uservo.id}" var="id" />
                    <c:set value="${uservo.roleList}" var="roleList" />
                    <c:set value="${uservo.permissionList}" var="permissionList" />
					<td>${id}</td>
					<td>${uservo.loginName}</td>
					<td>${uservo.name}</td>
					<td>${uservo.age}</td>
					<td>
					<c:forEach items="${roleList}" var="role" >
					   ${role.name}/
					</c:forEach>
					</td>
					<td>
                    <c:forEach items="${permissionList}" var="permission" >
                       ${permission.name}/
                    </c:forEach>
                    </td>
                    <td></td>
					<td><a href="/user/delete?id=${id}">删除</a>/<a href="/user/toUpdate?id=${id}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>