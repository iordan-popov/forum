package bg.swift.ip.forum.servlets;

import bg.swift.ip.forum.dao.TopicDAO;
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

@WebServlet(name = "CarServlet")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String message = request.getParameter("message");

        int forumId = Integer.parseInt(request.getParameter("forum_id"));

        User loggedUser = (User) request.getSession().getAttribute(User.USER_KEY);


        Topic newTopic = new Topic();

        newTopic.setName(name);
        newTopic.setMessage(message);
        newTopic.setDateCreated(LocalDateTime.now());
        newTopic.setDateModified(LocalDateTime.now());
        newTopic.setOwner(loggedUser);
        newTopic.setForumId(forumId);

        TopicDAO topicDAO = new TopicDAO();
        topicDAO.create(newTopic);

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
