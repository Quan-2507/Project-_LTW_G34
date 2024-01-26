package Controller.admin.trangchu;

import entity.Products;
import entity.Users;
import service.CategoryService;
import service.ProductService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="taikhoanController", value = "/taikhoan")
public class taikhoanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<Users> usersList;
        usersList = userService.getUser(2);
        request.setAttribute("usersList",usersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("taikhoan.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

