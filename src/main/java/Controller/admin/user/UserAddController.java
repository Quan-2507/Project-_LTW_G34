package Controller.admin.user;
import entity.Users;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name ="UserAddController", value = "/addUser")
public class UserAddController extends HttpServlet {
    private static final long SerialVersionUID = 1L;
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eString = request.getParameter("e");
        if (eString != null) {
            if (eString.equals("1")) {
                request.setAttribute("errMsg", "Username da ton tai!!!");
            }
        }
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("account") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("form-add-user.jsp");
            dispatcher.forward(request, response);
//        } else {
//            response.sendRedirect(request.getContextPath() + "/AdminLogin");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Users user = new Users();

        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setRole(Integer.parseInt((request.getParameter("role"))));
        user.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
        user.setAddress(request.getParameter("address"));
        user.setStatus(Integer.parseInt(request.getParameter("status")));
        user.setLastUpdate(String.valueOf((java.sql.Date.valueOf(LocalDate.now()))));
        userService.insert(user);
        System.out.println("DAOUsser"+ user);
        response.sendRedirect(request.getContextPath() + "/taikhoan");

    }
}

