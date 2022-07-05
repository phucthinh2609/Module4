<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 04/07/2022
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty condiments}">
        <h2>Sandwich include: </h2>
        <ul>
            <c:forEach items="${condiments}" var="condiment">
                <li>${condiment}</li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty condiments}">
        <h2>Sandwich is empty: </h2>
    </c:if>

    <a href="index.jsp">Back to search</a>
</body>
</html>
