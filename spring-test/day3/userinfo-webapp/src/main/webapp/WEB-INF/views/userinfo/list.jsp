<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2022-08-25
  Time: 오후 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사용자 목록</title>
    <link rel="stylesheet" type="text/css" media="screen"
          href="<c:url value="/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>">
</head>
<body>
<img src="<c:url value="/resources/images/iphone.jpg"/>"
     alt="아이폰" />
<table class="table table-hover">
    <tr>
        <th>no</th><th>name</th><th>password</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.no}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
