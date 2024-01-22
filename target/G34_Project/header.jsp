<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/27/2023
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
<c:url value="" var="url"></c:url>
<%
//    HttpSession session = request.getSession(false);
    String username = null;

    // Check if the user is logged in
    if (session != null) {
        username = (String) session.getAttribute("username");
    } else {
        // Check if the username is stored in a cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
    }
%>
<section id="header">
    <a href="home.jsp" style="max-width: 100px"><img src="img/logo/snapedit_1699446793064.png" class="logo" alt=""></a>
    <div>
        <ul id="navbar">
            <li><a  href="<%= request.getContextPath() %>/home">TRANG CHỦ</a></li>

            <li><a href="<%= request.getContextPath() %>/milktea">THỨC UỐNG</a></li>
            <li><a href="<%= request.getContextPath() %>/blog">KHUYẾN MÃI</a></li>
            <li><a href="<%= request.getContextPath() %>/about">VỀ CHÚNG TÔI</a></li>
            <li><a href="<%= request.getContextPath() %>/contact">LIÊN HỆ</a></li>
            <li class="lg-bag">
                <form class="search">
                    <input type="text" placeholder="Search" class="search__input">
                    <button type="button" class="search__btn">
                        <a><i class="fa-solid fa-magnifying-glass"></i></a>
                    </button>
                </form>
            </li>
            <li class="lg-bag"><a href="cart.html" onclick="showcart()"><i class="fa-solid fa-bag-shopping"></i></a></li>
            <% if (username != null) { %>
            <!-- If the user is logged in, display logout link -->
            <li><a href="logout">ĐĂNG XUẤT</a></li>
            <li><a href="Account.jsp" class="fa-regular fa-user"></a></li>
            <% } else { %>
            <!-- If the user is not logged in, display login link -->
            <li><a href="login">ĐĂNG NHẬP</a></li>
            <% } %>
            <a href="#" id="close"><i class="fa fa-times" aria-hidden="true"></i></a>
        </ul>
    </div>
    <div id="mobile">
        <form class="search">
            <input type="text" placeholder="Search" class="search__input">
            <button type="button" class="search__btn">
                <a><i class="fa-solid fa-magnifying-glass"></i></a>
            </button>
        </form>
        <a href="cart.html"><i class="fa-solid fa-bag-shopping"></i></a>
        <i id="bar" class="fa fa-outdent"></i>
    </div>
</section>