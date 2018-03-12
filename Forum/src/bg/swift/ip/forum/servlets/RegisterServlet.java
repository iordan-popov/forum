package bg.swift.ip.forum.servlets;

import bg.swift.ip.forum.entity.Gender;
import bg.swift.ip.forum.entity.User;
import bg.swift.ip.forum.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String name = request.getParameter("name");
       String email = request.getParameter("email");
       String password = request.getParameter("password");
       String confirmPassword = request.getParameter("confirm_pass");
       String age = request.getParameter("age");

      int age1 = Integer.parseInt(age);
       Gender gender = Gender.valueOf(request.getParameter("gender"));


        if (!"".equalsIgnoreCase(name) && !"".equalsIgnoreCase(email) && !"".equalsIgnoreCase(password)
                && !"".equalsIgnoreCase(confirmPassword) && !"".equalsIgnoreCase(age)){

            if (password.equals(confirmPassword)){

                User newUser = new User(email, name, password, gender, age1);

                UserDAO userDAO = new UserDAO();

                userDAO.create(newUser);

                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("pass_mismatch.jsp");

            }
        } else {
            response.getWriter().println("Something went wrong");
        }
    }
}
