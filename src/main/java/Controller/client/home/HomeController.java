package Controller.client.home;


import dao.ProductDAO;
import entity.Products;
import service.CategoryService;
import service.OrderService;
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

@WebServlet(name = "Home", value = "/home")
public class HomeController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        //load product best seller
        List<Products> bestSellers = ProductService.getInstance().bestSeller();
        request.setAttribute("bestSellers", bestSellers);

        //load product mới nhất
        List<Products> newProducts = ProductService.getInstance().newProducts();
        request.setAttribute("newProducts", newProducts);
        try {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
