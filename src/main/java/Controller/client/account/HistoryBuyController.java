package Controller.client.account;

import entity.Users;
import entity.Orders;
import entity.Products;
import service.UserService;
import service.OrderService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "History", value = "/history")
public class HistoryBuyController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("account");
        if (obj == null) {
            response.sendRedirect("login-signUp.jsp");
        } else {
            Users account = (Users) obj;
            ArrayList<Orders> listInvoiceWaitting = OrderService.getInstance().getListOfCus(0, 0, account.getId());
            request.setAttribute("listInvoiceWaitting", listInvoiceWaitting);
            ArrayList<Orders> listInvoiceConfirmed = OrderService.getInstance().getListOfCus(1, 0, account.getId());
            request.setAttribute("listInvoiceConfirmed", listInvoiceConfirmed);
            ArrayList<Orders> listInvoiceCanceled = OrderService.getInstance().getListOfCus(2, 0, account.getId());
            request.setAttribute("listInvoiceCanceled", listInvoiceCanceled);
            try {
                request.getRequestDispatcher("HistoryBuy.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

