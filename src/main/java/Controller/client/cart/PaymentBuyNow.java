package Controller.client.cart;

import entity.*;
import service.ProductService;
import utils.Email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Iterator;

@WebServlet(name = "PaymentBuyNow", value = "/PaymentBuyNow")
public class PaymentBuyNow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
        String idProductText = request.getParameter("id");
        int idProduct = Integer.parseInt(idProductText);
        String quantityText = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantityText);
        Products p = ProductService.getInstance().getProductById(idProduct);
        HttpSession session = request.getSession();
        session.setAttribute("BuyNowProduct", p);
        session.setAttribute("BuyNowQuantity", quantity);
        response.sendRedirect(url + "/buynow.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}