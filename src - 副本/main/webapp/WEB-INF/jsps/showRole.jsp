<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户角色</title>
</head>
<body>
	<form action="/roles/updateRole" method="post">
		<input type="hidden" name="role.id" value="${roleVo.role.id }" />
		<table>
			<tr>
				<td>name:</td>
				<td><input type="text" name="role.name" value="${roleVo.role.name }"></td>
			</tr>
			<tr>
				<td>permission:</td>
				<td>
					<c:forEach items="${roleVo.allPermission }" var="permission">
						<label><input name="permissionIds" type="checkbox" value="${permission.id }" />${permission.name } </label> 
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="修改"/></td>
			</tr>
		</table>
	</form>
</body>
</html>