<%@ page import="bg.swift.ip.forum.entity.Topic" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Integer topicId = Integer.parseInt(request.getParameter("topic_id"));%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Write a comment</h2>


<form action="comment.servlet?topic_id=<%=topicId%>" method="post">
    <div>
        <table>
            <tr>
                <td><label for="comment">Comment</label></td>
                <td><input type="text" id="comment" name="comment"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="submit_comment" value="post"></td>

                <input type="hidden" name="topicId" value="<%=request.getParameter("topic_id")%>">
            </tr>
        </table>
    </div>
</form>
</body>
</html>
