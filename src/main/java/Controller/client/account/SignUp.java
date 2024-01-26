package Controller.client.account;

import entity.Users;
import entity.VerifyAccount;
import service.UserService;
import utils.Email;
import utils.Encrypt;
import utils.NumberRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "SignUp", value = "/signUp")
public class SignUp extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String passwordEncrypt = Encrypt.toSHA1(password);
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        request.setAttribute("name", name);
        request.setAttribute("userName", userName);
        request.setAttribute("password", password);
        request.setAttribute("phoneNumber", phoneNumber);
        request.setAttribute("email", email);

        String err = "";
            if (UserService.getInstance().checkExistUserName(userName)) {
                err = "Tên tài khoản đã tồn tại!";
                request.setAttribute("errUserName", err);
            } else if (UserService.getInstance().checkExistEmail(email)) {
                err = "Email đã tồn tại!";
                request.setAttribute("errEmail", err);
            } else {
                Users users = new Users(name, userName, email, phoneNumber, passwordEncrypt);
                if (UserService.getInstance().registerAccount(users) > 0) {
                    Users usersAfterRegis = UserService.getInstance().selectAccountByUserName(users.getUserName());
                    String verifyCodeString = NumberRandom.getSoNgauNhien();
                    int verifyCode = Integer.parseInt(verifyCodeString);
                    LocalDateTime timeCode = LocalDateTime.now();
                    VerifyAccount verifyUsers = new VerifyAccount(usersAfterRegis.getId(), verifyCode, timeCode, false);
                    if (UserService.getInstance().insertVerify(verifyUsers) > 0) {
                        Email.sendEmail(usersAfterRegis.getEmail(), "Xác thực tài khoản",
                                "Mã xác thực tài khoản BobaTea của bạn là: " + verifyCode);
                        request.setAttribute("email", usersAfterRegis.getEmail());
                    }
                }
            }try {
            String url = "";
            if(err.length() == 0) {
                url = "ConfirmEmail.jsp";
            }else {
                url = "login-signUp.jsp";
            }
            request.getRequestDispatcher(url).forward(request, response);
         } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
