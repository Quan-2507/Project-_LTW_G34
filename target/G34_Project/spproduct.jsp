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
<jsp:include page="header.jsp"></jsp:include>

<section id="prodetails" class="section-p1">
    <div class="single-pro-image">
        <img src="img/products/trà%20sữa/matcha.jpeg" width="100%" id="MainImg" alt="">

        <!--            <div class="small-img-group">-->
        <!--                <div class="small-img-col">-->
        <!--                    <img src="../img/products/trà%20sữa/matcha.jpeg" width="100%" class="small-img" alt="">-->
        <!--                </div>-->
        <!--                <div class="small-img-col">-->
        <!--                    <img src="../img/single%20product/trà%20sữa%20matcha/Thiet-ke-chua-co-ten-35.webp" width="100%" class="small-img" alt="">-->
        <!--                </div>-->
        <!--                <div class="small-img-col">-->
        <!--                    <img src="../img/single%20product/trà%20sữa%20matcha/Premium%20PSD%20_%20Matcha%20drinks%20social%20media%20post%20or%20flyer%20template.jpg" width="100%" class="small-img" alt="">-->
        <!--                </div>-->
        <!--                <div class="small-img-col">-->
        <!--                    <img src="../img/single%20product/trà%20sữa%20matcha/Graphic%20design%20ideas.jpg" width="100%" class="small-img" alt="">-->
        <!--                </div>-->
        <!--            </div>-->
    </div>

    <div class="single-pro-details">
        <h4>Trà sữa matcha</h4>
        <h2>25.000đ</h2>
        <select>
            <option>Size</option>
            <option>M</option>
            <option>L</option>
        </select>
        <input type="number" value="1">
        <a href="cart.html"><button class="normal">Đặt hàng</button></a>
        <h4>Product Details</h4>
        <span>Là một hương vị trà sữa ấn tượng, độc đáo nên Trà sữa Matcha ngày càng được nhiều người yêu thích và sử dụng. Trà sữa Matcha có chứa chất giúp chống lại sự oxy hóa giúp hạn chế tác động từ tia cực tím, tăng cường khả năng kháng viêm và đem lại một làn da tươi trẻ. Theo nhiều nghiên cứu đã được thực hiện cho thấy, uống một tách trà sữa matcha sẽ cung cấp hàm lượng dinh dưỡng tương đương với 10 tách trà bình thường.</span>
    </div>
</section>

<section id="product1" class="section-p1">
    <h2>Best Seller</h2>
    <p>Những món bán chạy nhất Tháng 11<i class="fa-solid fa-fire" style="color: #f11404;"></i><i class="fa-solid fa-fire" style="color: #f11404;"></i></p>
    <div class="pro-container">
        <div class="pro">
            <img src="../img/products/trà%20sữa/matcha.jpg" alt="" onclick="window.location.href='sproduct.html';">
            <div class="des">
                <span>Trà sữa</span>
                <h5>Trà sữa matcha</h5>
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4>25.000đ</h4>
            </div>
            <a><button onclick="themvaogiohang(this)" style="cursor: pointer"><i class="fa-solid fa-cart-shopping cart"></i></button></a>
        </div>
        <div class="pro" >
            <img src="../img/products/cafe/americano.png" alt="" onclick="window.location.href='sproduct.html';">
            <div class="des">
                <span>Cà phê</span>
                <h5>Americano</h5>
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4>25.000đ</h4>
            </div>
            <a><button onclick="themvaogiohang(this)" style="cursor: pointer"><i class="fa-solid fa-cart-shopping cart"></i></button></a>
        </div>
        <div class="pro" >
            <img src="../img/products/nước%20ép/cacm.jpg" alt="" onclick="window.location.href='sproduct.html';">
            <div class="des">
                <span>Nước ép</span>
                <h5>Nước ép cam</h5>
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4>25.000đ</h4>
            </div>
            <a><button onclick="themvaogiohang(this)" style="cursor: pointer"><i class="fa-solid fa-cart-shopping cart"></i></button></a>
        </div>
        <div class="pro" >
            <img src="../img/products/sinh%20tố/cookie%20đá%20xay.jpg" alt="" onclick="window.location.href='sproduct.html';">
            <div class="des">
                <span>Sinh tố</span>
                <h5>Sinh tố cookie đá xay</h5>
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4>25.000đ</h4>
            </div>
            <a><button onclick="themvaogiohang(this)" style="cursor: pointer"><i class="fa-solid fa-cart-shopping cart"></i></button></a>
        </div>
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

<footer class="section-p1">
    <div class="col">
        <h4>Liên hệ</h4>
        <p><strong>Địa chỉ: </strong> K3/14C Đường Nguyễn Tri Phương, Thành phố Biên Hoà, Tỉnh Đồng Nai</p>
        <p><strong>Hotline: </strong> +01 2222 365 /(+91) 01 2345 6789</p>
        <p><strong>Thời gian hoạt động: </strong> 7:00 - 22:00, Thứ 2 - Thứ 7 / 9:00 - 20:00, Chủ nhật</p>
        <div class="follow">
            <h4>Theo dõi chúng tôi</h4>
            <div class="icon">
                <i class="fa-brands fa-facebook"></i>
                <i class="fa-brands fa-twitter"></i>
                <i class="fa-brands fa-instagram"></i>
                <i class="fa-brands fa-pinterest"></i>
                <i class="fa-brands fa-youtube"></i>
            </div>
        </div>
    </div>

    <div class="col">
        <h4>Thông tin</h4>
        <a href="about.html">Về chúng tôi</a>
        <a href="#">Thông tin giao hàng</a>
        <a href="#">Chính sách bảo mật</a>
        <a href="#">Điều khoản & Điều kiện</a>
        <a href="contact.html">Thông tin liên hệ</a>
    </div>

    <div class="col">
        <h4>Tài khoản của bạn</h4>
        <a href="signup-signin.html">Đăng nhập</a>
        <a href="cart.html">Xem giỏ hàng</a>
        <a href="#">Sản phầm yêu thích</a>
        <a href="#">Kiểm tra đơn hàng</a>
        <a href="contact.html">Trợ giúp</a>
    </div>


    <div class="col install">
        <h4>Cài đặt ứng dụng</h4>
        <p>Trên App Store hoặc Google Play</p>
        <div class="row">
            <img src="../img/pay/app.jpg" alt="">
            <img src="../img/pay/play.jpg" alt="">
        </div>
        <p>Cổng thanh toán an toàn</p>
        <img src="../img/pay/pay.png" alt="">
    </div>

    <div class="copyright">
        <p>copyright © 2023, BoBa Tea</p>
    </div>
</footer>

<a href="#"  class="scrollTop"><i class="fa-solid fa-arrow-up"></i></a>

<script>
    var MainImg = document.getElementById("MainImg");
    var smalling = document.getElementsByClassName("small-img");

    smalling[0].onclick = function() {
        MainImg.src = smalling[0].src;
    }
    smalling[1].onclick = function() {
        MainImg.src = smalling[1].src;
    }
    smalling[2].onclick = function() {
        MainImg.src = smalling[2].src;
    }
    smalling[3].onclick = function() {
        MainImg.src = smalling[3].src;
    }
</script>

<script src="../js/script.js"></script>
</body>
</html>
