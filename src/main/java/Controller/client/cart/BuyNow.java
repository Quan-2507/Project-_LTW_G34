package Controller.client.cart;


import entity.*;
import service.OrderService;
import service.ProductService;
import utils.Email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Iterator;

@WebServlet(name = "BuyNow", value = "/BuyNow")
public class BuyNow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("account");
        Products p = (Products) session.getAttribute("BuyNowProduct");
        int quantity = (Integer) session.getAttribute("BuyNowQuantity");
        double sum=(double) session.getAttribute("Sum");
        String name = u.getName();
        int phone=u.getPhoneNumber();
        String email=u.getEmail();
        String address = u.getAddress();
        String startContent="Thông tin khách hàng: "+"<br>"+"Họ và tên: "+name+"<br>"+"Số điện thoại: "+phone+"<br>"+"Email: "+email+"<br>"+"Địa chỉ nhận hàng: "+address+"<br>";
        String content="Các sản phẩm đã đặt hàng:"+"<br>";
        NumberFormat nF = NumberFormat.getCurrencyInstance();
        String endContent="Tổng tiền: "+nF.format(sum);
        Orders orders = new Orders(0,u.getId(),address,0,"Thanh toán khi nhận hàng","2023-01-15 00:00:00","Processing");
        if(OrderService.getInstance().insertOrder(orders)>0) {
            Orders lastest = OrderService.getInstance().latestOrder();
            Order_details odt = new Order_details(lastest.getId(), p.getId(),p.getQuantity(), p.getPrice(), p.getSize());
            OrderService.getInstance().insertOrderDetail(odt);
            content = "-Sản phẩm: " + p.getName() +" Giá: "+nF.format(p.getPrice())+ " Số lượng: " + quantity + "<br>";
        }
        session.setAttribute("BuyNowProduct", null);
        session.setAttribute("BuyNowQuantity", null);
        session.setAttribute("doneBuyNow","done");
        Email.sendEmail(u.getEmail(), "Xác nhận đơn hàng từ HomeDecor", startContent + "<br>" + content + endContent);
        response.sendRedirect(url + "/BuyNow.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}