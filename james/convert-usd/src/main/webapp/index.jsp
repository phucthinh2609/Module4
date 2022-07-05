<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 30/06/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert USD to VND</title>
</head>
<body>
    <fieldset>
        <form action="convert">
            <h1>Convert USD to VND</h1>
            <table>
                <tr>
                    <th>USD: </th>
                    <td><input type="number" name="usd" id="usd" value="0"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Convert</button></td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>
