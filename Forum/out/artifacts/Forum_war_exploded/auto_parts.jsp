<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="bg.swift.ip.forum.entity.User" %>
<%@ page import="bg.swift.ip.forum.dao.CommentDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="bg.swift.ip.forum.entity.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bg.swift.ip.forum.dao.TopicDAO" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AutoParts - Main</title>
</head>
<body>
<h1>Welcome to Auto Parts Forum</h1>

<%
    if (session.getAttribute("MyAttribute") != null) {
        LinkedHashMap hashMap = (LinkedHashMap) session.getAttribute("MyAttribute");
    }
    /*Checks if there is logged user*/
    User loggedUser = null;
    if (session.getAttribute(User.USER_KEY) != null) {
        loggedUser = (User) session.getAttribute(User.USER_KEY);
    }
%>

<div>Welcome, <%=loggedUser.getName()%>!</div>
<h3>Choose Forum</h3>
<table>
    <tr>
        <td><a href="cars_forum.jsp">cars </a>&nbsp;</td>
        <td><a href="trucks_forum.jsp">trucks </a>&nbsp;</td>
        <td><a href="motorcycles_forum.jsp">motorcycles</a></td>
    </tr>

</table>
<br>
<div><a href="new_comment.jsp?topic_id=<%=1%>">Add new comment</a></div>
<br>
Main Page Comments:
<ul>
    <%
         CommentDAO commentDAO = new CommentDAO();
        List<Comment> allComments = commentDAO.getCommentsByTopicId(1);
        for (Comment comment : allComments) {
    %>
    <li>Comment: <%= comment.getCommentText()%>  | written by: <%= comment.getOwner().getName()%> | on: <%=
        comment.getDateModified().toString()%></li>
    <%
        }
    %>
</ul>
<br>

<div> Click to: <a href="logout.jsp">Logout</a></div>
</body>
</html>
