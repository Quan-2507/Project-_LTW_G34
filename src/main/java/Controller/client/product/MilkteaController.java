package Controller.client.product;

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

@WebServlet(name ="MilkteaController", value = "/milktea")
public class MilkteaController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService  = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String type = request.getParameter("type");
        List<Products> productList;
        int currentPage = 1;
        int productsPerPage = 12;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
//        if (type==null) {
        productList = productService.getProductByPage(currentPage, productsPerPage);
/*
        } else if(type.equals("desc")){
            productList = productService.getProductByDESC(currentPage, productsPerPage);
        }
        else{
            productList = productService.getProductByACS(currentPage, productsPerPage);

        }
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getSalePrice()>o2.getSalePrice() ? -1: (o1.getSalePrice()<o2.getSalePrice())?1:0;
            }
        });
*/

        request.setAttribute("productList", productList);
        int numOfProduct = productService.numOfProducts();
        int numOfPages = numOfProduct / productsPerPage;
        if (numOfPages % productsPerPage > 0) {
            numOfPages++;
        }
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productsPerPage", productsPerPage);

        System.out.println(numOfPages);
        System.out.println(currentPage);
        System.out.println(productsPerPage);


//        List<Product> productList = productService.getAll();
//        request.setAttribute("productList", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("milktea.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
