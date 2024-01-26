package Controller.client.cart;

import entity.Cart;
import entity.Products;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateQuantity", value = "/updateQuantity")
public class UpdateQuantity extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        HttpSession session = request.getSession();
        String idProductText = request.getParameter("id");
        int idProduct = Integer.parseInt(idProductText);
        String quantityText = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantityText);
        Cart c = (Cart) session.getAttribute("Cart");
        c.put(idProduct, quantity);
        try {
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

