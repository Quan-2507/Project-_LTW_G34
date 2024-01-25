package Controller.client.account;

import dao.UserDAO;
import entity.Users;
import service.UserService;
import utils.Encrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        String encryptPass = Encrypt.toSHA1(password);
        // Validate login credentials
        if (userService.checkLogin(username, encryptPass)) {
            // Create a session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Create a cookie to remember the user
            Cookie cookie = new Cookie("user", username);
            cookie.setMaxAge(30 * 60); // Set the cookie's max age to 30 minutes
            response.addCookie(cookie);
            // Check if the username is the admin's email
            if ("admin@gmail.com".equals(username)) {
                response.sendRedirect("AdminHome.jsp");
            } else {
                response.sendRedirect("home.jsp"); // Redirect to the welcome page
                }
            }
            else {
                response.sendRedirect("login-signUp-ForgotPass.jsp?error=1"); // Redirect to the login page with an error parameter
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to login page if someone tries to access LoginServlet directly using GET method
        response.sendRedirect("login-signUp-ForgotPass.jsp");
    }
}