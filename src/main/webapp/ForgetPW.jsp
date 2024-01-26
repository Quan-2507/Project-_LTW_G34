<%@ page import="entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25/01/2024
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<jsp:include page="header.jsp"></jsp:include>

<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<%
    String done = (String)request.getAttribute("done");
    if(done!=null){
%>
<div class="container">
    <div id="LoginAndRegistrationForm">
        <div class="center" >Mật khẩu mới của bạn đã được gửi về Mail! <a href = <%=url%>/login-signUp.jsp>Đăng nhập</a>
    </div>
</div>
<%
}else{
%>
<div class="container">
    <div id="LoginAndRegistrationForm">
        <h1 id="formTitle">QUÊN MẬT KHẨU</h1>
            <form  method="post" action="fogotPassword">
                <%
                    String email = (String)request.getAttribute("email");
                    email =(email == null)?"":email;
                    String errEmail = (String)request.getAttribute("errEmail");
                    errEmail =(errEmail == null)?"":errEmail;
                %>
                <div class="center">
                    <span style="color: red"id="errEmail"><%=errEmail%></span>
                    <input type="text" class="mt-10 input-text" placeholder="Nhập Email" name="email" id="email" value="<%=email%>"/>
                </div>
<%--                <div class="form-group">--%>
<%--                    <button type="submit">--%>
<%--                        XÁC NHẬN--%>
<%--                    </button>--%>
<%--                </div>--%>
                <div class="center mt-20">
                    <input class="Submit-Btn" type="submit" value="XÁC NHẬN" >
                </div>
            </form>
        </div>
    </div>
</div>
<%
    }
%>

</body>
<script src="js/signin.js" type="text/javascript"></script>
<script src="js/validation.js" type="text/javascript"></script>
<script src="js/script.js"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<script src="js/ForgetPW.js"></script>
</html>
