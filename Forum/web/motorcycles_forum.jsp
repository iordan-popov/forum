<%@ page import="bg.swift.ip.forum.entity.Topic" %>
<%@ page import="bg.swift.ip.forum.dao.TopicDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="bg.swift.ip.forum.entity.Comment" %>
<%@ page import="bg.swift.ip.forum.dao.CommentDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Auto Parts - motors</title>
</head>
<body>

<h3>Motor Parts Forum</h3>

<div>
    <form action="car.servlet?forum_id=<%=4%>" method="post">

        <div>
            <table>
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input type="text" id="name" name="name"></td>
                </tr>
                <tr>
                    <td><label for="message">Message</label></td>
                    <td><input type="text" id="message" name="message"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="topic" value="Create Topic"></td>
                </tr>

            </table>
        </div>
    </form>
</div>
<br>
<div><a href="auto_parts.jsp"> Go Back</a></div>
<br>
<br>
<br>
Topics and Comments:

<ul>
    <%
        TopicDAO topicDAO = new TopicDAO();
        List<Topic> allTopics = topicDAO.getTopicsByForumId(4);
        if ( allTopics.size() != 0) {
            for (int i = 0; i < allTopics.size(); i++) {

    %>

    <li> <span style="font-weight: bold"> Topic: <%=allTopics.get(i).getName()%> | Message: <%= allTopics.get(i).getMessage()%></span>  |
        <a href="comment_topics.jsp?topic_id=<%=allTopics.get(i).getId()%>">Click to Comment</a>
        Created by: <%=allTopics.get(i).getOwner().getName()%>

    </li>

    <%
        CommentDAO commentDAO = new CommentDAO();
        List<Comment> allComments = commentDAO.getCommentsByTopicId(allTopics.get(i).getId());
        for (int y = 0; y < allComments.size(); y++) {
    %>
    <li>  - &nbsp; &nbsp; Comment: <%=allComments.get(y).getCommentText()%> | Created by: <%=allComments.get(y).getOwner().getName()%>
    </li>
    <%
                }
            }
        }

    %>


</ul>

</body>
</html>
