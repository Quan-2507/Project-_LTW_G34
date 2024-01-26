<%@ page import="entity.Cart" %>
<%@ page import="entity.Users" %><%--
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
<%@ page isELIgnored="false" %>
<style>

    .search__input1 {
        border: none;
        background: #f0deb8;
        /*display: none;*/
        height: 50px;
        opacity: 0; /* Bắt đầu với opacity 0 để ẩn đi */
        transition: opacity 10s ease; /* Thêm hiệu ứng chuyển động opacity với thời gian trễ là 0.5s */
    }

    .search__input1:focus {
        outline: none;
        border: none;
    }

    /* Hiển thị ô nhập liệu khi trỏ chuột vào nút tìm kiếm */
    .search1 .search__input1 {
        display: inline-block;
        opacity: 1; /* Hiển thị với opacity 1 khi hover */
        /*border: 1px solid #ccc; !* Thêm đường viền cho khung *!*/
        background: #f0deb8; /* Thêm màu nền cho ô nhập liệu */
    }

    .search__btn1 {
        background-color: #f0deb8;
        border: none;
    }

    /* Thêm màu nền cho kính lúp khi di chuột vào */
    .search__btn1:hover {
        background-color: #f0deb8; /* Thay đổi #your_color thành mã màu mong muốn */
    }




</style>
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
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    Cart cart = (Cart) session.getAttribute("Cart");
    int qtt = (cart != null) ? cart.list().size() : 0;
    String quantityItem = qtt + "";
    if (qtt > 99) quantityItem = "99+";
%>
<% Object obj = session.getAttribute("account");
    Users users = null;%>
<section id="header">
    <a href="home.jsp" style="max-width: 100px"><img src="img/logo/snapedit_1699446793064.png" class="logo" alt=""></a>
    <div>
        <ul id="navbar">
            <li><a href="<%=url%>/home">TRANG CHỦ</a></li>

            <li><a href="<%=url%>/milktea">THỨC UỐNG</a></li>
            <li><a href="<%=url%>/blog">KHUYẾN MÃI</a></li>
            <li><a href="<%=url%>/about">VỀ CHÚNG TÔI</a></li>
            <li><a href="<%=url%>/contact">LIÊN HỆ</a></li>
            <li class="lg-bag">
                <form class="search1" action="loadProductByName">
                    <input type="text" placeholder="Search" class="search__input1" name="name">
                    <button type="submit" class="search__btn1">
                        <a><i class="fa-solid fa-magnifying-glass"></i></a>
                    </button>
                </form>
            </li>
            <li class="lg-bag"><a class="nav-link" href="<%=url%>/Cart.jsp"><i class="fa-solid fa-bag-shopping"></i>
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"><%=quantityItem%><span class="visually-hidden">unread messages</span></span></a></li>
            <%--            <a href="${pageContext.request.contextPath }/member/cart" class="header__nav-item-link">--%>
            <%--                <i class="fas fa-shopping-cart"><c:set var="count" value="${0}"/></i>--%>


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
    <%--    <div id="mobile">--%>
    <%--        <form class="search">--%>
    <%--            <input type="text" placeholder="Search" class="search__input">--%>
    <%--            <button type="button" class="search__btn">--%>
    <%--                <a><i class="fa-solid fa-magnifying-glass"></i></a>--%>
    <%--            </button>--%>
    <%--        </form>--%>
    <%--        <a href="cart.html"><i class="fa-solid fa-bag-shopping"></i></a>--%>
    <%--        <i id="bar" class="fa fa-outdent"></i>--%>
    <%--    </div>--%>
</section>