<%--
  Created by IntelliJ IDEA.
  User: Iordan Popov
  Date: 22/02/2018
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>Login to Auto Parts Forum</h2>


<br>
<form method="post" action="login.servlet">
<table>
    <tr><td><label for="email">Email</label></td><td><input type="email" name="email" id="email"></td></tr>
    <tr><td><label for="password">Password</label></td><td><input type="password" name="password" id="password"></td></tr>
<tr><td></td><td><input type="submit" value="Login"></td></tr>
    <tr><td></td><td><input type="reset" value="Reset"></td></tr>
</table>
    <br>


<br>




</form>

</body>
</html>
