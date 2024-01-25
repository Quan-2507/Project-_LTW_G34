package Controller.client.product;

import entity.Products;
import service.CategoryService;
import service.ProductService;
import service.RateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "SearchController", value = "/loadProductByName")
public class SearchController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService  = new CategoryService();

    RateService rateService = new RateService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        List<Products> products =  productService.searchByName(name);
        System.out.println(products);
        Set<Integer> displayedProductIds = new HashSet<>();
        // Thêm một thuộc tính mới để lấy danh sách đánh giá cho mỗi sản phẩm trong danh sách bestSeller
        Map<Integer, Double> productRatings = new HashMap<>();

        Iterator<Products> iterator = products.iterator();

        int fullStars = 0;
        boolean hasHalfStar = false;
        Products p = null;
        double averageRating = 0;
        while (iterator.hasNext()) {
            p = iterator.next();
            // Kiểm tra xem sản phẩm đã được hiển thị chưa
            if (displayedProductIds.contains(p.getId())) {
                continue; // Đã hiển thị, bỏ qua lần lặp này
            }
            averageRating = rateService.getAverageRating(p.getId());
            productRatings.put(p.getId(), averageRating);
            if (Double.isNaN(averageRating)) {
                averageRating = 0.0; // Gán giá trị mặc định khi không có đánh giá
            }
            fullStars = (int) averageRating;
            hasHalfStar = averageRating - fullStars > 0;
            // Thêm sản phẩm vào danh sách đã hiển thị
            displayedProductIds.add(p.getId());
        }
        request.setAttribute("productRatings", productRatings);
        request.setAttribute("fullStars", fullStars);
        request.setAttribute("hasHalfStar", hasHalfStar);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("loadProductByName.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}