<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28/12/2023
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BoBa Tea</title>
    <link rel="icon" href="../img/logo/snapedit_1699446793064.png">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section id="page-banner" class="blog-header">

    <!--    <h2>#readmore</h2>-->

    <!--    <p>Read all case studies about our milktea! </p>-->

</section>

<section id="page-header">
    <div class="container">
        <ul class="breadcrumb" aria-label="breadcrumbs">
            <li><a  href="<%= request.getContextPath() %>/home">Trang chủ</a></li>
            <li class="active"><a href="#">Khuyến mãi</a></li>
        </ul>
        <h1>Khuyến mãi #1</h1>
    </div>
</section>

<section id="blog">
    <div class="blog-box">
        <div class="blog-img">
            <img src="img/blog/combotravai(1).png" alt="">
        </div>
        <div class="blog-details">
            <h4>SUPER SALE:</h4>
            <p>"CHILL" HÈ NGẤT NGÂY, ƯU ĐÃI BẤT TẬN CÙNG TRÀ VẢI TƯƠI DẦM</p>
            <a href="#">Đọc tiếp:</a>
        </div>
        <h1>10/11</h1>
    </div>
    <div class="blog-box">
        <div class="blog-img">
            <img src="img/blog/z3702410503848_518c41703a207d7af4e6368f67d40149.jpg" alt="">
        </div>
        <div class="blog-details">
            <h4>KHAI TRƯƠNG:</h4>
            <p>GRAND OPENING BOBA TEA NGUYỄN ÁI QUỐC & BOBA TEA ĐƯỜNG 3 THÁNG 2</p>
            <a href="#">Đọc tiếp</a>
        </div>
        <h1>03/01</h1>
    </div>
    <div class="blog-box">
        <div class="blog-img">
            <img src="img/blog/post%2030k%20momo_19.5.22-01_17857d6e-4937-48cf-93eb-3ce1eb21375f.png" alt="">
        </div>
        <div class="blog-details">
            <h4>VOUCHER:</h4>
            <p>THANH TOÁN MOMO, ƯU ĐÃI ĐỔ BỘ HOÀN TIỀN 30,000Đ</p>
            <a href="#">Đọc tiếp</a>
        </div>
        <h1>06/06</h1>
    </div>
    <div class="blog-box">
        <div class="blog-img">
            <img src="img/blog/11back-to-schoool-digital.jpg" alt="">
        </div>
        <div class="blog-details">
            <h4>SUPER SALE:</h4>
            <p>COMBO BACK TO SCHOOL - CHỈ TỪ 45,000Đ</p>
            <a href="#">Đọc tiếp</a>
        </div>
        <h1>01/10</h1>
    </div>
    <div class="blog-box">
        <div class="blog-img">
            <img src="img/blog/z3739000649076_0c9ea50e3c7e7b7f458edf64ce527bce.jpg" alt="">
        </div>
        <div class="blog-details">
            <h4>KHAI TRƯƠNG:</h4>
            <p>GRAND OPENING: BOBA TEA NGUYỄN TRÃI</p>
            <a href="#">Đọc tiếp</a>
        </div>
        <h1>14/01</h1>
    </div>
    <div class="blog-box">
        <div class="blog-img">
            <img src="img/blog/post_reopeining_le%20van%20tho,%20nguyen%20thiep,%20kdv_30.8.22-02_32b8887e-6f7e-408f-adb0-48cd42f323fe.png" alt="">
        </div>
        <div class="blog-details">
            <h4>KHAI TRƯƠNG:</h4>
            <p>GRAND OPENING - BOBA TEA LÊ VĂN THỌ, BOBA TEA NGUYỄN THIẾP & BOBA TEA KINH DƯƠNG VƯƠNG</p>
            <a href="#">Đọc tiếp</a>
        </div>
        <h1>07/09</h1>
    </div>
    <div class="blog-box">
        <div class="blog-img">
            <img src="img/blog/Untitled-1.jpg" alt="">
        </div>
        <div class="blog-details">
            <h4>MINI GAME:</h4>
            <p>TRUNG THU VUI VẦY - QUÀ ĐẦY YÊU THƯƠNG</p>
            <a href="#">Đọc tiếp</a>
        </div>
        <h1>07/06</h1>
    </div>
</section>

<section id="pagination" class="section-p1">
    <a href="#">1</a>
    <a href="blog2.html">2</a>
    <a href="#"><i class="fas fa-long-arrow-alt-right"></i></a>
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
