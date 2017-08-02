<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>用户登录</title></head>
<body>

<c:if test="${!empty error}">
    <span style="color: red;"><c:out value="${error}"/></span>
</c:if>

<form action="<c:url value="/myAdmin/login.html"/>" method="post">
    用户名：
    <input type="text" name="userName">
    <br/>
    密码：
    <input type="password" name="passWord">
    <br/>
    <input type="submit" value="登11录">
    <input type="reset" value="重置">
</form>

</body>
</html>
