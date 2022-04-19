package servlets;

import user.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = null;
        if (req.getParameter("signIn") != null) {
            UserService userService = new UserService();
            try {
                User user = userService.loginUser(req.getParameter("login"), req.getParameter("password"));
                req.setAttribute("login", user.getLogin());
                req.setAttribute("name", user.getName());
                req.setAttribute("age", user.getAge());
                req.setAttribute("role", user.getRole());
                if (user.getRole() == UserRole.ADMIN) {
                    req.setAttribute("listUser", userService.getListOfUsers(user));
                }
                path = "/home.jsp";
            } catch (Exception e) {
                req.setAttribute("warring", "Sign in failed");
                path = "/index.jsp";
            }

        } else if (req.getParameter("signUp") != null) {
            path = "/register.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
