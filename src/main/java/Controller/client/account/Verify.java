package Controller.client.account;

import entity.Users;
import entity.VerifyAccount;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;

@WebServlet(name = "Verify", value = "/verify")
public class Verify extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        String err ="";
        String verifyCodeString = request.getParameter("verify");
        int verifyCode = Integer.parseInt(verifyCodeString);
        String email = request.getParameter("email");

        String url = "";
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("account");
        Users account = null;
        if(obj != null) {
            account = (Users) obj; //lấy ra account bằng session với trường hợp là đăng nhập rồi nhưng tài khoản chưa xác thực, xác thực lại
        }else{
            account = UserService.getInstance().selectAccountByEmail(email);
        }
        VerifyAccount verifyAccount = UserService.getInstance().selectVerifyAccountByIdAccount(account.getId());
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(verifyAccount.getTimeCode(), currentTime);
        long timeExistCode = duration.getSeconds();
        if(verifyCodeString== null) {
            err ="Vui lòng nhập lại mã xác thực!";
            request.setAttribute("errCode",err);
            request.setAttribute("email",account.getEmail());
        }else if(timeExistCode > 600) {
            err ="Mã xác thực đã hết hiệu lực!";
            request.setAttribute("errCode",err);
            request.setAttribute("email",account.getEmail());
        }else if(verifyCode != verifyAccount.getVerifyCode()) {
            err ="Mã xác thực không chính xác!";
            request.setAttribute("errCode",err);
            request.setAttribute("email",account.getEmail());
        } else {
            verifyAccount.setStateVerify(true);
            UserService.getInstance().updateStateVerify(verifyAccount);
            account.setVerifyAccount(verifyAccount);
            if(obj != null) {
                session.setAttribute("account", account);
                url ="home";
            }else{
                url = "login-signUp.jsp";
            }
        }
        if(err.length() > 0) {
            url ="ConfirmEmail.jsp";
        }
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("html/text; charset= UTF-8");
//        String err ="";
//        String verifyCodeString = request.getParameter("verify");
//        int verifyCode = Integer.parseInt(verifyCodeString);
//        String email = (String) request.getAttribute("email");
//        System.out.println(email);
//        String url = "";
//        HttpSession session = request.getSession();
//        Object obj = session.getAttribute("account");
//        Users account = null;
//        if(obj != null) {
//            account = (Users) obj; //lấy ra account bằng session với trường hợp là đăng nhập rồi nhưng tài khoản chưa xác thực, xác thực lại
//        }else{
//            account = UserService.getInstance().selectAccountByEmail(email);
//        }
//        VerifyAccount verifyAccount = UserService.getInstance().selectVerifyAccountByIdAccount(account.getId());
//        LocalDateTime currentTime = LocalDateTime.now();
//        Duration duration = Duration.between(verifyAccount.getTimeCode(), currentTime);
//        long timeExistCode = duration.getSeconds();
//        if(timeExistCode > 600) {
//            err ="Mã xác thực đã hết hiệu lực!";
//            request.setAttribute("errCode",err);
//            request.setAttribute("email",account.getEmail());
//        }else if(verifyCode != verifyAccount.getVerifyCode()) {
//            err ="Mã xác thực không chính xác!";
//            request.setAttribute("errCode",err);
//            request.setAttribute("email",account.getEmail());
//        }else {
//            verifyAccount.setStateVerify(true);
//            UserService.getInstance().updateStateVerify(verifyAccount);
//            account.setVerifyAccount(verifyAccount);
//            if(obj != null) {
//                session.setAttribute("account", account);
//                url ="home";
//            }else{
//                url = "login-signUp.jsp";
//            }
//        }
//        if(err.length() > 0) {
//            url ="ConfirmEmail.jsp";
//        }
//        try {
//            request.getRequestDispatcher(url).forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }
//    }
}