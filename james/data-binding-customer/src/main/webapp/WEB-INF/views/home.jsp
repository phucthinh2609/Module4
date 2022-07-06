<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
  <h2>Home</h2>
  <fieldset>
    <legend>Login</legend>
    <form:form action="login" method="post" modelAttribute="login">
      <table>
        <tr>
          <td><form:label path="account">Account</form:label></td>
          <td><form:input path="account"/></td>
        </tr>
        <tr>
          <td><form:label path="password">Account</form:label></td>
          <td><form:input path="password"/></td>
        </tr>
        <tr>
          <td></td>
          <td><form:button>Login</form:button></td>
        </tr>
      </table>
    </form:form>
  </fieldset>
</body>
</html>
