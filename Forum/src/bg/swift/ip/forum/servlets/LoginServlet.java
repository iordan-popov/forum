package bg.swift.ip.forum.servlets;

import bg.swift.ip.forum.dao.UserDAO;
import bg.swift.ip.forum.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        /*This does verification that fields are not empty*/
        if (!"".equalsIgnoreCase(email) && !"".equalsIgnoreCase(password)) {
            UserDAO userDAO = new UserDAO();
        /*This searches for the user in db*/
            User loginUser = userDAO.findByEmailAndPassword(email, password);

        /*This verifies a user exists in db and verifies the password provided is the same in order to open session*/
            if (loginUser != null && password.equals(loginUser.getPassword())) {
                session.setAttribute(User.USER_KEY, loginUser);
                response.sendRedirect("auto_parts.jsp");
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("Username or password does not match.");
                }
            }
        }
    }
}
