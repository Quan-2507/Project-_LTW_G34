<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 14/01/2024
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%
    // Check if the user is already logged in
   // HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("username") != null) {
%>
<p>You are already logged in as <%= session.getAttribute("username") %>. <a href="logout">Đăng xuất</a></p>
<%
} else {
%>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div id="LoginAndRegistrationForm">
        <h1 id="formTitle">Đăng nhập</h1>
        <div id="formSwitchBtn">
            <button onclick="ShowLoginForm()"  id="ShowLoginBtn" class="active">Đăng nhập</button>
            <button onclick="ShowRegistrationForm()"  id="ShowRegistrationBtn">Đăng ký</button>
        </div>
        <div id="LoginFrom">
            <form method="post" action="login">
                <div class="center">
                    <input id="LoginEmail" class="input-text" name="username" type="email" placeholder="Email*" >
                    <input id="LoginPassword" class="mt-10 input-text" name="password" type="password" minlength="8" placeholder="Nhập mật khẩu*" >
                </div>
                <div class="forgot-pass-remember-me mt-10">
                    <div class="forgot-pass">
                        <a id="ForgotPassword" href="JavaScript:void(0);" onclick="ShowForgotPasswordForm()" >Quên mật khẩu?</a>
                    </div>
                    <div class="remember-me">
                        <input id="rememberMe" type="checkbox">
                        <label for="rememberMe">Nhớ mật khẩu</label>
                    </div>
                </div>

                <div class="center mt-20">
                    <input onclick="return ValidateLoginForm()"  class="Submit-Btn" type="submit" value="Đăng nhập" id="LoginBtn">
                </div>
            </form>
            <p class="center mt-20 dont-have-account">
                Bạn chưa có tài khoản?
                <a href="JavaScript:void(0);" onclick="ShowRegistrationForm()">Đăng ký ngay</a>
            </p>
        </div>
        <div id="RegistrationFrom">
            <form method="post" action="">
                <div class="center">
                    <input id="RegiName" class="input-text" type="text" placeholder="Họ và tên">
                    <input id="RegiEmailAddres" class="input-text mt-10" type="email" placeholder="Nhập địa chỉ Email">
                    <input id="RegiPassword" class="mt-10 input-text" type="password" placeholder="Nhập mật khẩu">
                    <input id="RegiConfirmPassword" class="mt-10 input-text" type="password" placeholder="Nhập lại mật khẩu*">
                </div>
                <div class="center mt-20">
                    <input onclick="return ValidateRegistrationForm();" class="Submit-Btn" type="submit" value="Đăng ký" id="RegistrationitBtn">
                </div>
            </form>
            <p class="center mt-20 already-have-account">
                Bạn đã tài khoản?
                <a href="#" onclick="ShowLoginForm()">Đăng nhập ngay</a>
            </p>
        </div>
        <div id="ForgotPasswordForm">
            <form method="post" action="${pageContext.request.contextPath}/FogotPassword">
                <div class="center mt-20">
                    <input class="input-text " type="email" id="forgotPassEmail" placeholder="Địa chỉ Email">
                </div>
                <div class="center mt-20">
                    <input onclick="return ValidateForgotPasswordForm();" class="Submit-Btn" type="submit" value="Tiếp tục" id="PasswordResetBtn" >
                </div>
            </form>
            <p class="center mt-20 already-have-account">
                Quay lại
                <a href="JavaScript:void(0);" onclick="ShowLoginForm()">Trang đăng nhập</a> | <a href="JavaScript:void(0);" onclick="ShowRegistrationForm()">Trang đăng ký</a>
            </p>
        </div>
    </div>
</div>


<% if (request.getParameter("error") != null) { %>
<p style="color: red;">Email hoặc mật khẩu không đúng! Vui lòng nhập lại.</p>
<% } %>
<%
    }
%>
<jsp:include page="footer.jsp"></jsp:include>

</body>
<script src="js/signin.js" type="text/javascript"></script>
<script src="js/validation.js" type="text/javascript"></script>
<script src="js/script.js"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
</html>
