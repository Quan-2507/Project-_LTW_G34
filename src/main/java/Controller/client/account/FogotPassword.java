package Controller.client.account;

import entity.Users;
import service.UserService;
import utils.Email;
import utils.Encrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.SecureRandom;

@WebServlet(name = "FogotPassword", value = "/fogotPassword")
public class FogotPassword extends HttpServlet {
    final static String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    final static String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String number = "0123456789";
    final static String special = "!@#$&$%*+,-./:;()<=>[]^_`{}|~";

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder randomString = new StringBuilder();
        randomString.append(lowerCase.charAt(random.nextInt(lowerCase.length())));

        // Thêm ít nhất một chữ hoa
        randomString.append(upperCase.charAt(random.nextInt(upperCase.length())));

        // Thêm ít nhất một số
        randomString.append(number.charAt(random.nextInt(number.length())));

        // Thêm ít nhất một ký tự đặt biệt
        randomString.append(special.charAt(random.nextInt(special.length())));

        // Thêm các ký tự còn lại
        int length = 6 + random.nextInt(8); // Chiều dài ngẫu nhiên từ 6 đến 20
        for (int i = 4; i < length; i++) {
            String allChars = lowerCase + upperCase + number + special;
            randomString.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        return randomString.toString();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset= UTF-8");
        String email = request.getParameter("email");
        request.setAttribute("email", email);
        String err = "";
        String url = "";
        if(email==null){
            err = "Vui lòng nhập Email!";
            request.setAttribute("errEmail", err);
            url = "/ForgetPW.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        else if (UserService.getInstance().selectAccountByEmail(email)==null) {
            err = "Email không chính xác!";
            request.setAttribute("errEmail", err);
            url = "/ForgetPW.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            Users account = UserService.getInstance().selectAccountByEmail(email);
            String newpassword = generateRandomString();
            String pwEncrypt = Encrypt.toSHA1(newpassword);
            if (UserService.updatePassword(pwEncrypt, account.getId()) > 0) {
                Email.sendEmail(account.getEmail(), "Mật khẩu mới của bạn", "Thông tin đăng nhập BobaTea:"+"<br>" + "- Email: " + email + "<br>" + "-Mật khẩu mới: " + newpassword);
                request.setAttribute("done","oke");
                url = "/ForgetPW.jsp";
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }
}