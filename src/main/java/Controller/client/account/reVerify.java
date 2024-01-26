package Controller.client.account;

import entity.Users;
import service.UserService;
import utils.Email;
import utils.NumberRandom;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "reVerify", value = "/reVerify")
public class reVerify extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("account");
        Users account = null;
        if(obj != null) {
            account = (Users) obj; //lấy ra account bằng session với trường hợp là đăng nhập rồi nhưng tài khoản chưa xác thực, xác thực lại
        }else{
            account = UserService.getInstance().selectAccountByEmail(email);
        }
        String code = NumberRandom.getSoNgauNhien();
        int codeNew = Integer.parseInt(code);
        LocalDateTime timeNew = LocalDateTime.now();
        if(UserService.getInstance().updateVerify(codeNew, timeNew,  account.getId()) > 0) {
            Email.sendEmail(account.getEmail(), "Xác thực tài khoản", "Mã xác thực tài khoản HomeDecor của bạn là: " + code);
            request.setAttribute("email", account.getEmail());
        }
        try {
            request.getRequestDispatcher("ConfirmEmail.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}