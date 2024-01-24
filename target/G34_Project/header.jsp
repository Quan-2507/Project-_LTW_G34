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
<section id="header">
    <a href="home.jsp" style="max-width: 100px"><img src="img/logo/snapedit_1699446793064.png" class="logo" alt=""></a>
    <div>
        <ul id="navbar">
            <li><a href="<%= request.getContextPath() %>/home">TRANG CHỦ</a></li>

            <li><a href="<%= request.getContextPath() %>/milktea">THỨC UỐNG</a></li>
            <li><a href="<%= request.getContextPath() %>/blog">KHUYẾN MÃI</a></li>
            <li><a href="<%= request.getContextPath() %>/about">VỀ CHÚNG TÔI</a></li>
            <li><a href="<%= request.getContextPath() %>/contact">LIÊN HỆ</a></li>
            <li class="lg-bag">
                <form class="search1" action="loadProductByName">
                    <input type="text" placeholder="Search" class="search__input1" name="name">
                    <button type="submit" class="search__btn1">
                        <a><i class="fa-solid fa-magnifying-glass"></i></a>
                    </button>
                </form>
            </li>
            <%--            <li class="lg-bag"><a href="cart.html" onclick="showcart()"><i class="fa-solid fa-bag-shopping"></i></a></li>--%>
            <a href="${pageContext.request.contextPath }/member/cart" class="header__nav-item-link">
                <i class="fas fa-shopping-cart"><c:set var="count" value="${0}"/></i>

                <c:forEach items="${sessionScope.cart}" var="map">
                    <c:set var="count" value="${count + 1}"/>
                </c:forEach>
                <span>${count }</span> </a>
            <c:choose>
                <c:when test="${username==null}">
                    <div class="header__no-cart">
                            <%--                                            <img src="${url}/img/home/no-cart.png" class="img__no-cart">--%>
                        <div class="no__cart-text">
                            <span>Đăng nhập để xem giỏ hàng</span>
                        </div>

                    </div>
                </c:when>
                <c:otherwise>
                    <div class="header__has-cart" id="removeCart">
                        <ul class="list-unstyled badge-open mCustomScrollbar header__cart-list"
                            data-mcs-theme="minimal-dark" id="contentCart">
                            <c:forEach items="${sessionScope.cart}" var="map">
                                <li class="header__cart-item header__cart-view">
                                    <c:url
                                            value="${map.value.product.image}"
                                            var="imgUrl"></c:url><a class="header__cart-link"
                                                                    href="${pageContext.request.contextPath}/product/detail?id=${map.value.product.id}">
                                    <img src="${imgUrl}" alt="" width="10"
                                         height="20" class="header__cart-img">
                                    <div class="overflow-h header__cart-name">
                                        <p><b>${map.value.product.name }</b></p>
                                        <p>${map.value.quantity} * ${map.value.product.price }đ </p>
                                    </div>
                                    <a
                                            href="${pageContext.request.contextPath}/cart/remove?pId=${map.value.product.id} ">
                                        <button
                                                type="button" class="close">×
                                        </button>
                                    </a>

                                </a>
                                </li>
                            </c:forEach>
                        </ul>
                        <footer class="header__cart-footer">
                            <a href="${pageContext.request.contextPath }/member/cart"
                               class="header__cart-footer-btn">Xem tất cả</a>
                        </footer>
                    </div>
                </c:otherwise>
            </c:choose>
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
<%--        <form class="search">--%>
<%--            <input type="text" placeholder="Search" class="search__input">--%>
<%--            <button type="button" class="search__btn">--%>
<%--                <a><i class="fa-solid fa-magnifying-glass"></i></a>--%>
<%--            </button>--%>
<%--        </form>--%>
        <a href="cart.html"><i class="fa-solid fa-bag-shopping"></i></a>
        <i id="bar" class="fa fa-outdent"></i>
    </div>
</section>