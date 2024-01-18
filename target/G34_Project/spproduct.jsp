<%@ page import="entity.Products" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/1/2024
  Time: 2:16 PM
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
    <title>BoBa Tea</title>
    <link rel="icon" href="img/logo/snapedit_1699446793064.png">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<style>
    #product__size {
        font-size: 16px;
        margin-top: 10px;
        margin-bottom: 10px;
    }

    #product__size input[type="radio"] {
        display: none;
    }

    #product__size label {
        display: inline-block;
        padding: 8px 12px;
        background-color: #f0deb8;
        color: #000000;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
        margin-right: 12px; /* Khoảng cách giữa các nút */
    }

    #product__size input[type="radio"]:checked + label {
        background-color: #7e5730;
        color: white;
    }

    #product__size label:hover {
        background-color: #7e5730;
        color: white;
    }


</style>
<jsp:include page="header.jsp"></jsp:include>

<section id="prodetails" class="section-p1">
    <div class="single-pro-image">
        <div>
            <c:url value="${products.image}" var="imgUrl"></c:url>
            <img src="<c:url value='${products.image}'/>" width="100%" id="MainImg" alt="Large Image">
        </div>
        <div class="small-img-group">
            <c:forEach items="${moreIMG}" var="img">
                <div class="small-img-col">
                    <c:url value="${img}" var="imgMore"></c:url>
                    <img src="<c:url value='${img}'/>" width="100%" class="small-img" alt="">
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="single-pro-details">
        <h4>${products.name}</h4>
        <h2>${products.price}</h2>
        <div id="product__size">
            Size:
            <input type="radio" id="sizeS" name="size" value="S" style="margin-left:12px;">
            <label for="sizeS" style="margin-right:12px;">S</label>
            <input type="radio" id="sizeM" name="size" value="M">
            <label for="sizeM" style="margin-right:12px;">M</label>
        </div>
        <%--        <input type="number" value="1">--%>
        <a href="cart.html">
            <button class="normal">Đặt hàng</button>
        </a>
        <h4>Chi tiết</h4>
        <span>${products.description}</span>
    </div>
</section>

<section id="product1" class="section-p1">
    <h2>Best Seller</h2>
    <p>Những món bán chạy nhất <i class="fa-solid fa-fire" style="color: #f11404;"></i><i
            class="fa-solid fa-fire" style="color: #f11404;"></i></p>
    <div class="pro-container">
        <c:forEach items="${bestSeller}" var="bsler" begin="0" end="3">
            <c:url value="${bsler.image}" var="imgUrl"></c:url>
            <div class="pro">
                <img src="<c:url value='${bsler.image}'/>" alt="" onclick="window.location.href='${pageContext.request.contextPath}/spproduct?id=${bsler.id}'">
                <div class="des">
                    <span>${bsler.category.name}</span>
                    <h5>${bsler.name}</h5>
                    <div class="star">
                        <c:forEach begin="1" end="5" var="star">
                            <c:choose>
                                <c:when test="${star <= productRatings[bsler.id]}">
                                    <i class="fas fa-star"></i>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${star >= productRatings[bsler.id] and star - productRatings[bsler.id] < 1}">
                                            <i class="fas fa-star-half-alt"></i>
                                        </c:when>
                                        <c:otherwise>
                                            <i class="fa-regular fa-star"></i>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>

                    <h4>${bsler.price} VND</h4>
                </div>
                <a>
                    <button onclick="themvaogiohang(this)" style="cursor: pointer"><i
                            class="fa-solid fa-cart-shopping cart"></i></button>
                </a>
            </div>
        </c:forEach>

    </div>
</section>

<section id="newsletter" class="section-p1 section-m1">
    <div class="newstext">
        <h4>Đăng Ký Để Nhận Bản Tin</h4>
        <p>Để lại E-mail để được cập nhật các thông báo mới nhất và <span>các deal "hời".</span>
        </p>
    </div>
    <div class="form">
        <input type="text" placeholder="Địa chỉ email của bạn">
        <button class="normal">Đăng Ký</button>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>

<a href="#" class="scrollTop"><i class="fa-solid fa-arrow-up"></i></a>

<script>
    var MainImg = document.getElementById("MainImg");
    var smalling = document.getElementsByClassName("small-img");

    smalling[0].onclick = function () {
        MainImg.src = smalling[0].src;
    }
    smalling[1].onclick = function () {
        MainImg.src = smalling[1].src;
    }
    smalling[2].onclick = function () {
        MainImg.src = smalling[2].src;
    }
    smalling[3].onclick = function () {
        MainImg.src = smalling[3].src;
    }
</script>

<script src="../js/script.js"></script>
<script>function addCart() {
    var id = document.getElementById("id").value;
    var quantity = document.getElementById('quantity').value;
    var size = document.querySelector('input[name="size"]:checked').value;
    $.ajax({
        url: '${pageContext.request.contextPath }/cart/add',
        type: 'POST',
        data: {
            pId: id,
            quantity: quantity,
            size: size,
        },
        success: function (data) {

            var row = document.getElementById('contentCarted');
            row.innerHTML = data;
            alert('Thêm vào giỏ hàng thành công');

        }
    });
}
</script>
</body>
</html>
