package Controller.client.home;


import dao.ProductDAO;
import entity.Products;
import service.CategoryService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name ="HomeController", value = "/home")
public class HomeController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService  = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Products> bestSellers = productDAO.bestSeller(0);
        request.setAttribute("bestSellers", bestSellers);

        // Forward to a JSP or other view for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp"); // Assuming you have a JSP named "home.jsp"
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
