package Controller.admin.user;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name ="UserDeleteController", value = "/deleteUser")
public class UserDeleteController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userService.delete(Integer.parseInt(id));
        System.out.println(id);
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath() + "/taikhoan");

//        } else {
//            response.sendRedirect(request.getContextPath() + "/taikhoan ");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
