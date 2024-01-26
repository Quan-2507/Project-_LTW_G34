package Controller.client.account;

import entity.Users;
import entity.VerifyAccount;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "changeInfo", value = "/changeInfo")
public class ChangeInfo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("TenHT");
        Integer phoneNumber = Integer.valueOf(request.getParameter("SDTHT"));
        String email = request.getParameter("GmailHT");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("DCHT");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("account");
        Users account = (Users) obj;
        String emailInDb = account.getEmail();
        String res = "";
        if (name == null || name.trim().isEmpty()) {
            res = "Vui lòng nhập họ và tên!";
        } else if (email == null || email.trim().isEmpty()) {
            res = "Vui lòng nhập Email!";
        } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            res = "Email không hợp lệ!";
        } else if(UserService.getInstance().checkExistEmail(email) && !email.equals(emailInDb)){
            res = "Email đã tồn tại trong hệ thống!";
        }else if (phoneNumber == null ) {
            res = "Vui lòng nhập số điện thoại!";
        }else if (address == null || address.trim().isEmpty()) {
            res = "Vui lòng nhập địa chỉ!";
        } else if (dateOfBirth == null) {
            res = "Vui lòng chọn ngày sinh!";
        } else {

            Users accountNew = new Users(account.getId(), name, email, phoneNumber,  address, dateOfBirth);
            VerifyAccount vrf = UserService.getInstance().getVrfOfAccount(account.getId());
            accountNew.setVerifyAccount(vrf);
            session.setAttribute("account", accountNew);
            if (UserService.getInstance().updateInfor(accountNew) > 0) {
                res = "Cập nhật thành công!";
            } else {
                res = "Cập nhật thất bại!";
            }
        }
        request.setAttribute("res", res);
        request.getRequestDispatcher("ChangeInfor.jsp").forward(request, response);
    }
}
