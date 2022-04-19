package servlets;

import user.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/index.jsp";
        try {
            User user = new User();
            UserService userController = new UserService();
            user.setLogin(req.getParameter("login"));
            user.setName(req.getParameter("name"));
            user.setAge(Integer.parseInt(req.getParameter("age")));
            user.setRole(UserRole.USER);
            user.setPassword(req.getParameter("password"));
            userController.registeredUser(user);
            req.setAttribute("warring", "Sign up completed successfully!");
        } catch (Exception e) {
            path = "/register.jsp";
            req.setAttribute("warring", "Sign up failed try again!");
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
