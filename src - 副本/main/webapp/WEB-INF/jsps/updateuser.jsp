<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/js/addUser.js"></script>
<link rel="stylesheet"
    href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
    src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/user/update" method="post">
		<table class="table table-striped">
		<form>
			<th>添加用户</th>
			<tr>
				<input type="hidden" name="id" value="${user.id }">
				<td>登陆名：</td>
				<td><input type="text" name="loginName" id='userName' value="${user.loginName}" /></td>
				<td><label id='uNameMessage'></label></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name" id='name' value="${user.name}"/></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" value="${user.age}"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" value="${user.password}"/></td>
			</tr>
			<tr>
			<c:forEach var="role" items="${rolelist}" varStatus="status" >
			<td>
			<input type="checkbox" name="roleList[${status.index }].id"  value="${role.id}"/>${role.name}</td>
			</c:forEach>
			</tr>
			<tr>
				<td><input type="submit" value="修改"  /></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
			</form>
		</table>
	</form>

</body>
</html>