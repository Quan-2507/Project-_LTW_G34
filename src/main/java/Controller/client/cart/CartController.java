package Controller.client.cart;


import entity.Cart;
import entity.Categories;
import entity.Products;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "cartController", value = "/cartController")
public class CartController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        HttpSession session = request.getSession();
        String idText = request.getParameter("id");
        int id = Integer.parseInt(idText);
        String quantityText = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantityText);
        Cart c = (Cart) session.getAttribute("Cart");
        if(c == null) c= new Cart();
        if (c.get(id) != null) {
                c.put(id, quantity);
        }else{
            Products p = ProductService.getInstance().getProductById(id);
            if (p != null) c.put(p);
        }
        session.setAttribute("Cart", c);
        try {
            request.getRequestDispatcher("Cart.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

