package bg.swift.ip.forum.servlets;

import bg.swift.ip.forum.dao.CommentDAO;
import bg.swift.ip.forum.dao.TopicDAO;
import bg.swift.ip.forum.entity.Comment;
import bg.swift.ip.forum.entity.Forum;
import bg.swift.ip.forum.entity.Topic;
import bg.swift.ip.forum.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer topicId = Integer.parseInt(request.getParameter("topic_id"));

        String comment = request.getParameter("comment");

        CommentDAO commentDAO = new CommentDAO();
        User loggedUser = (User) request.getSession().getAttribute(User.USER_KEY);

        Comment newComment = new Comment();

        newComment.setCommentText(comment);
        newComment.setDateCreated(LocalDateTime.now());
        newComment.setDateModified(LocalDateTime.now());
        newComment.setOwner(loggedUser);
        newComment.setTopicId(topicId);

        commentDAO.create(newComment);
        TopicDAO topicDAO = new TopicDAO();
        int forumId = topicDAO.getForumId(topicId);

        switch (forumId) {

            case 1:
                response.sendRedirect("auto_parts.jsp");
                break;
            case 2:
                response.sendRedirect("cars_forum.jsp");
                break;
            case 3:
                response.sendRedirect("trucks_forum.jsp");
                break;
            case 4:
                response.sendRedirect("motorcycles_forum.jsp");
                break;
        }
    }
}
