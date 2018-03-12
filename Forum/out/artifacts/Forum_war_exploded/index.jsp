<%@ page import="java.time.LocalDateTime" %>
<%@ page import="bg.swift.ip.forum.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% User loggedUser = null;
  if (session.getAttribute(User.USER_KEY) != null){
    loggedUser = (User) session.getAttribute(User.USER_KEY);
  }
%>
<html>
<head>
  <title>Forum - index</title>
</head>
<body>
<h1>Welcome to Auto Parts Forum</h1>

<% if (loggedUser != null){%>
<span>Your name is: <%= loggedUser.getName()%></span>
<div>You can logout: <a href="logout.jsp">here</a> </div>

<% } else { %>

<div>You can login <a href = "login.jsp">here</a></div>
<div>You can register <a href="register.jsp">here</a></div>

<% } %>

<br>
<br>
<div>Current Date: <%=LocalDateTime.now()%></div>
</body>
</html>
