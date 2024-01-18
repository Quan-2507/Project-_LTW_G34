<%@ page import="entity.Products" %>
<%@ page import="entity.Rates" %>
<%@ page import="service.RateService" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page buffer="64kb" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%
    // Retrieve the productList attribute from the request
    List<Products> bestSeller = (List<Products>) request.getAttribute("bestSeller");
%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zxx">
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

<section id="hero">
    <h4>CỬA HÀNG TRÀ SỮA 1 Việt Nam</h4>
    <h2>Trà sữa nhà làm - Giá hạt dẻ</h2>
    <h1>Đến với BoBa Tea!</h1>
    <p>Tiết kiệm hơn với mã giảm giá & giảm đến 50%!</p>
    <a href="products.html">
        <button class="normal">Đặt hàng ngay</button>
    </a>
</section>

<section id="feature" class="section-p1">
    <div class="fe-box">
        <img src="img/features/f1.png" alt="">
        <h6>Miễn phí giao hàng</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f2.png" alt="">
        <h6>Đặt hàng online</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f3.png" alt="">
        <h6>Tiết kiệm</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f4.png" alt="">
        <h6>Nhiều ưu đãi</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f5.png" alt="">
        <h6>Vui vẻ với khách hàng</h6>
    </div>
    <div class="fe-box">
        <img src="img/features/f6.png" alt="">
        <h6>Hỗ trợ 24/7</h6>
    </div>

</section>

<section id="product1" class="section-p1">
    <h2>Best Seller</h2>
    <p>Những món bán chạy nhất Tháng 11<i class="fa-solid fa-fire" style="color: #f11404;"></i><i class="fa-solid fa-fire" style="color: #f11404;"></i></p>
<%--    <div class="pro-container">--%>
<%--        <%--%>
<%--            RateService rateService = new RateService();--%>
<%--            Set<Integer> displayedProductIds = new HashSet<>();--%>

<%--            Iterator<Products> iterator = bestSeller.iterator();--%>

<%--            while (iterator.hasNext()) {--%>
<%--                Products p = iterator.next();--%>

<%--                // Kiểm tra xem sản phẩm đã được hiển thị chưa--%>
<%--                if (displayedProductIds.contains(p.getId())) {--%>
<%--                    continue; // Đã hiển thị, bỏ qua lần lặp này--%>
<%--                }--%>

<%--                double averageRating = rateService.getAverageRating(p.getId()); // Trung bình đánh giá--%>
<%--                if (Double.isNaN(averageRating)) {--%>
<%--                    averageRating = 0.0; // Gán giá trị mặc định khi không có đánh giá--%>
<%--                }--%>
<%--                int fullStars = (int) averageRating;--%>
<%--                boolean hasHalfStar = averageRating - fullStars > 0;--%>

<%--                // Thêm sản phẩm vào danh sách đã hiển thị--%>
<%--                displayedProductIds.add(p.getId());--%>
<%--        %>--%>
<%--        <div class="pro" onclick="window.location.href='${pageContext.request.contextPath}/spproduct?id=<%=p.getId()%>'" >--%>

<%--            <img src="<%=p.getImage() %>" alt="">--%>
<%--            <div class="des">--%>
<%--                <span><%= p.getCategory().getName() %></span>--%>
<%--                <h5><%= p.getName() %></h5>--%>
<%--                <div class="star">--%>
<%--                    <% for (int i = 0; i < fullStars; i++) { %>--%>
<%--                    <i class="fas fa-star"></i>--%>
<%--                    <% } %>--%>
<%--                    <% if (hasHalfStar) { %>--%>
<%--                    <i class="fas fa-star-half-alt"></i>--%>
<%--                    <% } %>--%>
<%--                </div>--%>
<%--                <h4><%= p.getPrice() %> VND</h4>--%>
<%--            </div>--%>

<%--            <a><i class="fa-solid fa-cart-shopping cart"></i></a>--%>
<%--        </div>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
<%--    </div>--%>
</section>

<section id="banner" class="section-m1">
    <h4>Buổi sáng tỉnh táo</h4>
    <h2>Giảm đến <span>50% Off</span> - Áp dụng cho sinh viên</h2>
    <a href="coffeeSale.html">
        <button class="normal">Khám phá thêm</button>
    </a>
</section>

<section id="product2" class="section-p1">
    <h2>Món mới</h2>
    <p>Ra mắt các món soda</p>
    <div class="pro-container">
        <div class="pro" >
            <img src="img/products/soda/blue%20sky.jpg" alt="" onclick="window.location.href='sproduct.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda blue sky</h5>
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
            <img src="img/products/soda/phúc%20bồn%20tử.jpg" alt="" onclick="window.location.href='sproduct2.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda phúc bồn tử</h5>
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
        <div class="pro">
            <img src="img/products/soda/soda%20chanh.png" alt="" onclick="window.location.href='sproduct2.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda chanh</h5>
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
        <div class="pro">
            <img src="img/products/soda/soda%20chanh%20muối.jpg" alt="" onclick="window.location.href='sproduct2.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda chanh muối</h5>
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
        <div class="pro">
            <img src="img/products/soda/soda%20dâu.png" alt="" onclick="window.location.href='sproduct2.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda dâu</h5>
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
        <div class="pro">
            <img src="img/products/soda/soda%20dâu%20tằm.jpg" alt="" onclick="window.location.href='sproduct2.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda dâu tằm</h5>
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
        <div class="pro">
            <img src="img/products/soda/soda%20dưa%20hấu.jpg" alt="" onclick="window.location.href='sproduct2.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda dưa hấu</h5>
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
        <div class="pro">
            <img src="img/products/soda/soda%20kiwi.png" alt="" onclick="window.location.href='sproduct2.html';">
            <div class="des">
                <span>Soda</span>
                <h5>Soda kiwi</h5>
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

<section id="sm-banner" class="section-p1">
    <div class="banner-box">
        <h4>Sức khoẻ</h4>
        <h2>Thanh lọc cơ thể mỗi ngày</h2>
        <span>với 1 ly nước ép Kiwi</span>
        <button class="white">Xem thêm</button>
    </div>
    <div class="banner-box banner-box2">
        <h4>Mùa hè nóng bức</h4>
        <h2>Giải nhiệt</h2>
        <span>bằng soda chanh</span>
        <button class="white">Xem thêm</button>
    </div>
</section>

<section id="banner3">
    <div class="banner-box">
        <!--        <h2>SUPER SALE</h2>-->
        <!--        <h3>-50% OFF</h3>-->
    </div>
    <div class="banner-box banner-box2">
        <!--        <h2>SUPER SALE</h2>-->
        <!--        <h3>-50% OFF</h3>-->
    </div>
    <div class="banner-box banner-box3">
        <!--        <h2>SUPER SALE</h2>-->
        <!--        <h3>-50% OFF</h3>-->
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

<script src="js/script.js"></script>
</body>
</html>