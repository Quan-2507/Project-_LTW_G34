package Controller.client.product;

import entity.Images;
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

@WebServlet(name ="SpProductController", value = "/spproduct")
public class SpProductController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService  = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> moreIMG;
        List<Products> bestSeller;

        String id = request.getParameter("id");
        Products products = productService.getID(Integer.parseInt(id));
        moreIMG = productService.getMoreImage(Integer.parseInt(id));
        bestSeller = productService.bestSeller(Integer.parseInt(id));

        request.setAttribute("moreIMG",moreIMG);
        request.setAttribute("bestSeller",bestSeller);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("spproduct.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
