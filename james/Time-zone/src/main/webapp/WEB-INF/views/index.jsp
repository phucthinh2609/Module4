<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 01/07/2022
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The World Clock</title>
    <style type="text/css">
        select {
            width: 200px;
            height: 20px;
        }
    </style>
</head>
<body>
  <h2>Current Local Times Around the World</h2>
  <span>Local time curent in ${city}: <strong>${date}</strong></span>
  <form id="locale" action="time-zone">
      <select name="city" onchange="document.getElementById('locale').submit()">
          <option value="Asia/Ho_Chi_Minh" selected>Select option</option>
          <option value="Asia/Ho_Chi_Minh">Hồ Chí Minh</option>
          <option value="Singapore">Singapore</option>
          <option value="Asia/Hong_Kong">Hong Kong</option>
          <option value="Asia/Seoul">Seoul</option>
          <option value="Asia/Tokyo">Tokyo</option>
          <option value="Europe/London">London</option>
          <option value="Europe/Madrid">Madrid</option>
          <option value="Australia/Sydney">Sydney</option>
      </select>
  </form>
</body>
</html>
