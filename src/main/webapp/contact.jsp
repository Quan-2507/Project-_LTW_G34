<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28/12/2023
  Time: 11:56 AM
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

<section id="page-banner" class="contact-header">

    <!--        <h2>#let's_talk</h2>-->
    <!--        -->
    <!--        <p>LEAVE A MESSAGE. We love to hear you!</p>-->

</section>

<section id="page-header">
    <div class="container">
        <ul class="breadcrumb" aria-label="breadcrumbs">
            <li><a href="home.html">Trang chủ</a></li>
            <li class="active"><a href="#">Liên hệ</a></li>
        </ul>
        <h1>Liên hệ</h1>
    </div>
</section>

<section id="contact-details" class="section-p1">
    <div class="details">
        <span>LIÊN LẠC</span>
        <h2>Hãy ghé thăm một trong các địa điểm đại lý của chúng tôi hoặc liên hệ với chúng tôi ngay hôm nay</h2>
        <h3>Cơ sở chính</h3>
        <div>
            <li>
                <i class="fa fa-map-marker"></i>
                <p>K3/14C Đường Nguyễn Tri Phương, Thành phố Biên Hoà, Tỉnh Đồng Nai</p>
            </li>
            <li>
                <i class="fa-solid fa-envelope"></i>
                <p>contact@example.com</p>
            </li>
            <li>
                <i class="fas fa-phone-alt"></i>
                <p>contact@example.com</p>
            </li>
            <li>
                <i class="fa-solid fa-clock"></i>
                <p>7:00 - 22:00, Thứ 2 - Thứ 7 / 9:00 - 20:00, Chủ nhật</p>
            </li>
        </div>
    </div>

    <div class="map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d489.68390463774756!2d106.81136783526884!3d10.927731826390907!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3174d97c12925667%3A0xd80087abef3aaaa5!2sMin&#39;%20House%20-%20Tea%20%26%20More!5e0!3m2!1svi!2s!4v1699765045974!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
</section>

<section id="form-details">
    <form action="" onsubmit="return false">
        <span>ĐỂ LẠI Ý KIẾN GÓP Ý</span>
        <h2>Chúng tôi luôn sẵn sàng lắng nghe</h2>
        <input type="text" placeholder="Tên" id="name">
        <input type="text" placeholder="E-mail" id="email">
        <input type="text" placeholder="Tiêu đề">
        <textarea id="msg" cols="30" rows="10" placeholder="Lời nhắn"></textarea>
        <button class="normal" onclick="message()">Submit</button>
        <div class="message">
            <div class="success" id="success">Your Message Successfully Sent!</div>
            <div class="danger" id="danger">Fields Can't be Empty!</div>
        </div>
    </form>

    <div class="people">
        <div>
            <img src="../img/member/a1.jpg" alt="">
            <p><span>Tran Minh Quan</span> Top bookies from Dong Lao <br> Phone: 0937170300 <br>Email: 21130495@st.hcmuaf.edu.vn</p>
        </div>
        <div>
            <img src="../img/member/a2.jpg" alt="">
            <p><span>Kieu Thi Ngoc Quy</span> Haters Gon' hate, players Gon' play. <br> Phone: 0102002003 <br>Email: 21130504@st.hcmuaf.edu.vn</p>
        </div>
        <div>
            <img src="../img/member/a4.webp" alt="">
            <p><span>Tran Thi Thien Nhan</span> The strong one doesn’t win. The one that wins is strong. <br> Phone: 02995594849 <br>Email: 21130461@st.hcmuaf.edu.vn</p>
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
<jsp:include page="footer.jsp"></jsp:include>

<a href="#" class="scrollTop"><i class="fa-solid fa-arrow-up"></i></a>

<script src="../js/script.js"></script>
<script>
    function message() {
        var Name = document.getElementById('name');
        var email = document.getElementById('email');
        var msg = document.getElementById('msg');
        const success = document.getElementById('success');
        const danger = document.getElementById('danger');

        if (Name.value === '' || email.value === '' || msg.value === ''){
            danger.style.display = 'block';
        }
        else {
            setTimeout(()=>{
                Name.value = '';
                email.value = '';
                msg.value = '';
            }, 2000);

            success.style.display = 'block';
        }

        setTimeout(()=>{
            danger.style.display = 'none';
            success.style.display = 'none';
        }, 4000);
    }
</script>
</body>
</html>
