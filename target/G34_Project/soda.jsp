<%@ page import="entity.Products" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/1/2024
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page buffer="64kb" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%
    // Retrieve the productList attribute from the request
    List<Products> productList = (List<Products>) request.getAttribute("productList");
%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Milktea Store</title>
    <link rel="icon" href="../img/logo/snapedit_1699446793064.png">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
          integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style2.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/Cart.css">
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
        background: #088178;

    }
</style>

<jsp:include page="header.jsp"></jsp:include>

<section id="page-banner"></section>

<section id="page-header">
    <div class="container">
        <ul class="breadcrumb" aria-label="breadcrumbs">
            <li><a href="<%= request.getContextPath() %>/home">Trang chủ</a></li>
            <li class="active"><a href="#">Thức uống</a></li>
        </ul>
        <h1>Thức uống</h1>
        <div class="separator-icon gray"></div>
        <ul class="menu">
            <li class="">
                <a href="<%= request.getContextPath() %>/milktea" class="dish text-uppercase">Trà sữa</a>
            </li>

            <li class="">
                <a href="<%= request.getContextPath() %>/tea" class="dish text-uppercase">Trà</a>
            </li>

            <li class="">
                <a href="<%= request.getContextPath() %>/coffee" class="dish text-uppercase">Cà phê</a>
            </li>

            <li class="">
                <a href="<%= request.getContextPath() %>/yaourt" class="dish text-uppercase">Yaourt</a>
            </li>

            <li class="active">
                <a href="<%= request.getContextPath() %>/soda" class="dish text-uppercase">Soda</a>
            </li>

            <li class="">
                <a href="<%= request.getContextPath() %>/smoothie" class="dish text-uppercase">Sinh tố</a>
            </li>

            <li class="">
                <a href="<%= request.getContextPath() %>/juice" class="dish text-uppercase">Nước ép</a>
            </li>

        </ul>

    </div>

</section>

<section id="#section-ca-phe-wrapper">
    <section id="product1" class="section-p1">
        <div class="pro-container">
            <%
                Iterator<Products> iterator = productList.iterator();
                while (iterator.hasNext()) {
                    Products p = iterator.next();
            %>
            <div class="pro" onclick="window.location.href='${pageContext.request.contextPath}/spproduct?id=<%=p.getId()%>'">
                <img src="<%=p.getImage() %>" alt="">
                <div class="des">
                    <span><%= p.getCategory().getName() %></span>
                    <h5><%= p.getName() %></h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4><%= p.getPrice() %> VND</h4>
                </div>
                <a><i class="fa-solid fa-cart-shopping cart"></i></a>
            </div>
            <%
                }
            %>


        </div>
    </section>

    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"  href="?page=${currentPage-1}">&laquo;</a></li>
        </c:if>

        <c:set var="startPage" value="${currentPage - 5}" />
        <c:if test="${startPage lt 1}">
            <c:set var="startPage" value="1" />
        </c:if>

        <c:set var="endPage" value="${startPage + 9}" />
        <c:if test="${endPage gt numOfPages}">
            <c:set var="endPage" value="${numOfPages}" />
        </c:if>

        <c:forEach begin="${startPage}" end="${endPage}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt numOfPages}">
            <li class="page-item"><a class="page-link" href="?page=${currentPage+1}">&raquo;</a></li>
        </c:if>
    </ul>

    <section id="newsletter" class="section-p1 section-m1">
        <div class="newstext">
            <h4>Sign Up For Newsletter</h4>
            <p>Get E-mail updates about our latest shop and <span>special offers.</span>
            </p>
        </div>
        <div class="form">
            <input type="text" placeholder="Your email address">
            <button class="normal">Sign Up</button>
        </div>
    </section>
</section>

<jsp:include page="footer.jsp"></jsp:include>

<a href="#" class="scrollTop"><i class="fa-solid fa-arrow-up"></i></a>

<script src="../js/script.js"></script>
</body>
<script src="https://code.jquery.com/jquery-3.6.2.js"></script>
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
</html>
