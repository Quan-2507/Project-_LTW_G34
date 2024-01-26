<%@ page import="entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25/01/2024
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BoBa Tea</title>
    <link rel="icon" href="img/logo/snapedit_1699446793064.png">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<jsp:include page="header.jsp"></jsp:include>
<%
    Object obj = session.getAttribute("username");
    Object flag = request.getAttribute("flag");
    String account = (String) obj;
    if (account != null && flag==null) {
%>
<section class="signup mt-5">
    <!-- <img src="images/signup-bg.jpg" alt=""> -->
    <div class="contain">
        <div class="signup-content">
            <form id="signup-form" class="signup-form" action="changepassword" method="post" >
                <h5>ĐỔI MẬT KHẨU</h5>
                <%String success  = (String)request.getAttribute("success");
                    success =(success == null)?"":success;
                %>
                <div class="text-success text-center mt-3" id ="res"><%=success%></div>
                <div class="form-SignUp">
                    <%
                        String errPassword = (String)request.getAttribute("errPass");
                        errPassword =(errPassword == null)?"":errPassword;
                        String errNewPassword = (String)request.getAttribute("errNewPass");
                        errNewPassword =(errNewPassword == null)?"":errNewPassword;
                        String errReNewPassword = (String)request.getAttribute("errReNewPass");
                        errReNewPassword =(errReNewPassword == null)?"":errReNewPassword;
                    %>
                    <div class="form-group">
                        <label>Mật khẩu hiện tại<span class="text-danger">*</span></label><span class="text-danger" id="errPW"><%=errPassword%></span>
                        <input type="password" class="form-input" placeholder="Nhập mật khẩu hiện tại" name="password"
                               id="password"/>
                    </div>
                    <div class="form-group">
                        <label for="re_password">Mật khẩu mới<span class="text-danger">*</span></label><span class="text-danger" id="errNPW"><%=errNewPassword%></span>
                        <input type="password" class="form-input" placeholder="Nhập mật khẩu mới" name="new_password"
                               id="new_password"/>
                    </div>
                    <div class="form-group">
                        <label for="re_password">Xác nhận mật khẩu<span class="text-danger">*</span></label><span class="text-danger" id="errReNPW"><%=errReNewPassword%></span>
                        <input type="password" class="form-input" placeholder="Nhập lại mật khẩu mới" name="re_password"
                               id="re_password"/>
                    </div>

                </div>
                <div class="form-group">
                    <button type="submit">XÁC NHẬN</button>
                </div>
            </form>
        </div>
    </div>
    <%
    } else {
        if (account == null) {
    %>
    <div class="container p-0 mgt text-center fw-bold">Bạn chưa đăng nhập! <a href = <%=url%>/login>Đăng nhập</a></div>
    <%
            }
        }
    %>
</section>
<script src="js/ChangePW.js"></script>
<script>
    if($('#res').text() === "Đổi mật khẩu thành công!") {
        setTimeout(function () {
            window.location.href = 'homePage';
        }, 2000);
    }
</script>
</body>
<script src="js/script.js"></script>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
</html>
