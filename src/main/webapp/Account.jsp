<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 16/01/2024
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
<style>
    .nav-tabs {
        max-width: 720px;
        display: flex;
        list-style: none;
        margin: 0px auto;
        padding-top: 20px;
        border-bottom: 3px solid #ddd;
    }

    .nav-tabs li {
        margin-right: 10px;
    }

    .nav-tabs li a {
        color: black;
        display: block;
        padding: 6px 30px;
        text-decoration: none;
        position: relative;
    }

    .nav-tabs li a::after {
        content: "";
        height: 3px;
        width: 100%;
        position: absolute;
        left: 0px;
        bottom: -3px;
        background: transparent;
    }

    .nav-tabs li.active a::after, .nav-tabs li:hover a::after {
        background: #7e5730;

    }
</style>
<jsp:include page="header.jsp"></jsp:include>
<section id="page-header">
    <div class="container">
        <div class="separator-icon gray"></div>
        <ul class="menu">
            <li class="active">
                <a href="<%= request.getContextPath() %>/ChangePW.jsp" class="dish text-uppercase">Đổi mật khẩu</a>
            </li>

            <li class="">
                <a href="<%= request.getContextPath() %>/changeInfo.jsp" class="dish text-uppercase">Thay đổi thông tin</a>
            </li>
        </ul>
    </div>

</section>

<jsp:include page="footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.6.2.js"></script>

<script src="js/script.js"></script>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
<script>
    $(document).ready(function () {
        $('.tab-content-item').hide();
        $('.tab-content-item:first-child').fadeIn();
        $('.nav-tabs li').click(function () {
            $('.nav-tabs li').removeClass('active');
            $(this).addClass('active');

            let id_tabs = $(this).children('a').attr('href');
            $('.tab-content-item').hide();
            $(id_tabs).fadeIn();
            return false;
        });
    });

</script>
</body>
</html>