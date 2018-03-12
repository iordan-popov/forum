<%--
  Created by IntelliJ IDEA.
  User: Iordan Popov
  Date: 24/02/2018
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Integer topicId = 1;%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Write a comment</h2>



<form action="comment.servlet?topic_id=<%=topicId%>" method="post">
    <div>

        <table>
            <tr><td></td><td></td></tr>

            <tr><td><label for="comment">Comment</label></td>
                <td><input type="text" id="comment" name="comment"></td></tr>
            <tr><td></td><td><input type="submit" name="submit_comment" value="post"></td></tr>

        </table>


    </div>
</form>

</body>
</html>
