<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23/01/2024
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BoBa Tea</title>
    <link rel="icon" href="img/logo/snapedit_1699446793064.png">
    <link rel="stylesheet" href="css/sigin-signup.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
</head>
<body>
<section class="signup mt-5">
    <%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        String email =(String)request.getAttribute("email");
        String err =(String)request.getAttribute("errCode");
        email = (email == null)?" ": email;
        err = (err == null)?" ": err;%>
    <div class="contain">
            <div id="LoginAndRegistrationForm">
                <h1 id="formTitle">Xác thực tài khoản của bạn</h1>
                <div id="ResetPasswordForm">
                    <form action="<%=url%>/verify" method ="post" onsubmit="return verifyAccount()">
                        <p class="text-group" style="margin-bottom: 0">Chúng tôi đã gửi mã xác thực đến <span class="text-primary" id="email"><%=email%></span></p>
                        <p class="">Vui lòng nhập mã để xác thực tài khoản của bạn</p>
                        <p class="mb-0">Mã xác thực chỉ có hiệu lực trong vòng 10 phút</p>
                        <div class="center">
                            <span class="text-danger" id="errVerify"><%=err%></span>
                            <input id="NewPassword" class="mt-10 input-text" type="text" placeholder="Nhập mã xác thực ở đây">
                        </div>
                        <p class="text-group"><a href="<%=url%>/reVerify?email=<%=email%>">Nhấn vào đây</a> để nhận lại mã xác thực</p>
<%--                        <div class="center mt-20">--%>
<%--                            <input onclick="return ValidateResetPasswordForm();" class="Submit-Btn" type="submit" value="Thay đổi" id="PasswordChangeBtn">--%>
<%--                        </div>--%>
                        <div class="center mt-20">
                            <button type="submit" id="confirm" >XÁC NHẬN</button>
                        </div>
                    </form>
                    <p class="center mt-20 already-have-account">
                        <%Object obj = session.getAttribute("account");%>
                        <a class="text-decoration-none" href="<%=url%>/<%=(obj==null)? "login-signUp-ForgotPass.jsp" : "home" %>">Quay lại</a>
                    </p>
                </div>

            </div>
    </div>
<%--        <div class="signup-content">--%>
<%--            <form id="verify-form" class="signup-form" action="<%=url%>/verify" method ="post" onsubmit="return verifyAccount()">--%>
<%--                <div class="text-end pe-4">--%>
<%--                    <%Object obj = session.getAttribute("account");%>--%>
<%--                    <a class="text-decoration-none" href="<%=url%>/<%=(obj==null)? "login-signUp-ForgotPass.jsp" : "home" %>">Bỏ qua</a>--%>
<%--                </div>--%>
<%--                <img src="img/logo/snapedit_1699446793064.png" alt="" width="400px">--%>
<%--                <h5>Xác thực tài khoản của bạn</h5>--%>
<%--                <div class="verify">--%>
<%--                    <p class="text-group" style="margin-bottom: 0">Chúng tôi đã gửi mã xác thực đến <span class="text-primary" id="email"><%=email%></span></p>--%>
<%--                    <input type="text" name="email" value ="<%=email%>"class="d-none">--%>
<%--                    <p class="">Vui lòng nhập mã để xác thực tài khoản của bạn</p>--%>
<%--                    <p class="mb-0">Mã xác thực chỉ có hiệu lực trong vòng 10 phút</p>--%>
<%--                    <div class="form-group text-center">--%>
<%--                        <span class="text-danger" id="errVerify"><%=err%></span>--%>
<%--                        <input type="text" class="form-input" placeholder="Nhập mã xác thực ở đây" name="verify" id="verify"/>--%>
<%--                    </div>--%>
<%--                    <p class="text-group"><a href="<%=url%>/reVerify?email=<%=email%>">Nhấn vào đây</a> để nhận lại mã xác thực</p>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <button type="submit" id="confirm" >XÁC NHẬN</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
</section>
<script>
    function verifyAccount() {
        var verifyVal = document.getElementById("verify");
        var error = document.getElementById("errVerify");
        var flag = true;
        if(verifyVal.value == "") {
            flag = false;
            error.innerHTML = '(*)Vui lòng nhập mã xác thực!';
        }
        return flag;
    }
</script>
</body>
</html>