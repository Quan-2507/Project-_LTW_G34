package Controller.admin.user;
import entity.Categories;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;


@WebServlet(name ="ProductAddController", value = "/addProduct")
public class ProductAddController extends HttpServlet {
    private static final long SerialVersionUID = 1L;
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("account") != null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-add-product.jsp");
        dispatcher.forward(request, response);
//        } else {
//            response.sendRedirect(request.getContextPath() + "/AdminLogin");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Create a new Products instance
        Products product = new Products();

        // Set the properties of the product from the form parameters
        product.setName(request.getParameter("name"));
        int category = categoryService.get(request.getParameter("category")).getId();
        product.setStatus(Integer.parseInt(request.getParameter("status")));
        product.setDescription(request.getParameter("description"));
        product.setSize(request.getParameter("size"));
        product.setCostPrice(Integer.parseInt(request.getParameter("costPrice")));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setImages(request.getParameter("images"));
        product.setLastUpdate((java.sql.Date.valueOf(LocalDate.now()))); // Set the current date as lastUpdate

        // Assuming you have a ProductService class with an insert method
        productService.insert(product);

        response.sendRedirect(request.getContextPath() + "/sanpham"); // Redirect to the product list page
    }
}

