<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 04/07/2022
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Page</title>
</head>
<body>
    <form action="/calculator" method="post">
        <h1>Calculator</h1>
        <table>
            <tr>
                <td>
                    <input type="number" value="0" name="numberOne">
                    <input type="number" value="0" name="numberTwo">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" value="addition" name="calculation">Addition(+)</button>
                    <button type="submit" value="subtraction" name="calculation">Subtraction(-)</button>
                    <button type="submit" value="multiplication" name="calculation">Multiplication(*)</button>
                    <button type="submit" value="division" name="calculation">Division(/)</button>
                </td>
            </tr>
        </table>
    </form>
    </br>
    <c:if test="${empty error}">
        <p>Result of ${numberOne} ${calculation} ${numberTwo}: <strong>${result}</strong></p>
    </c:if>
    <c:if test="${not empty error}">
        <p>Result of ${numberOne} ${calculation} ${numberTwo}:  <strong style="color: darkred">${error}</strong></p>
    </c:if>
</body>
</html>
