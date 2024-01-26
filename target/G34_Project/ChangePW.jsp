<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25/01/2024
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<header>
    <div class="container-fluid bgcolor-orange" >
        <div class="container ">
            <div class="row ">
                <div class="col-md-9 col-sm-9 col-8 col-4 d-flex align-items-center  ">
                    <a class ="nav-link" href="<%=url%>/homePage"> <img style="width: 150px" src="image/logoWeb.png">
                    </a>
                </div>
                <div class="col-md-3 col-sm-3 col-4 py-3 px-0 d-flex align-items-center justify-content-end">
                    <ul class="d-flex m-0 list-unstyled justify-content-end">
                        <li class="px-3 pt-1"><a class="nav-link active" aria-current="page" href="#"><i class="fa fa-phone" aria-hidden="true"></i></a></li>
                        <li class="px-3 pt-1"><a class="nav-link" href="#"><i
                                class="fa fa-facebook-official" aria-hidden="true"></i></a></li>
                        <li class="px-3 pt-1"><a class="nav-link" href="#"><i
                                class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        <li class="px-3 pt-1"><a class="nav-link" href="#"><i
                                class="fa fa-twitter" aria-hidden="true"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</header>
<%
    Object obj = session.getAttribute("account");
    Object flag = request.getAttribute("flag");
    Users account = (Users) obj;
    if (account != null && flag==null) {
%>
<section class="signup mt-5">
    <!-- <img src="images/signup-bg.jpg" alt=""> -->
    <div class="contain">
        <div class="signup-content">
            <form id="signup-form" class="signup-form" action="changePassword" method="post" >
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
    <div class="container p-0 mgt text-center fw-bold">Bạn chưa đăng nhập! <a href = <%=url%>/SignIn.jsp>Đăng nhập</a></div>
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
</html>
