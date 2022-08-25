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
    <title>Title</title>
</head>
<body>
    ${msg}
    <table>
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

