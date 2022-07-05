<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 30/06/2022
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <fieldset>
        <h1>Home</h1>
        <form action="validate" method="post">
            <table>
                <tr>
                    <th>Email: </th>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Check</button></td>
                </tr>
            </table>
        </form>
        <c:if test="${success == true}">
            <p style="color: green">${message}</p>
        </c:if>
        <c:if test="${success == false}">
            <p style="color: darkred">${message}</p>
        </c:if>

    </fieldset>
</body>
</html>
