<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28/12/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.io.File" %>
<%@ page import="entity.Products" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="entity.Cart" %>
<%@ page import="entity.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BoBa Tea</title>
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
    <link rel="icon" href="img/logo/snapedit_1699446793064.png">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    NumberFormat nF = NumberFormat.getCurrencyInstance();
    Cart cart = (Cart) session.getAttribute("Cart");
    Users users = (Users) session.getAttribute("users");
%>
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
    <div class="pro-container">
        <%ArrayList<Products> bestSellers = (ArrayList<Products>) request.getAttribute("bestSellers");
            if (!bestSellers.isEmpty() && bestSellers != null) {
                for (Products p : bestSellers) {%>
        <div class="pro">
            <img src="<%=url%><%=(p.getImages().isEmpty())?"":p.getImages()%>">
            <div class="des">
                <span><%=p.getCategory().getName()%></span>
                <h5><%=p.getName()%></h5>
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4><%=p.getPrice()%>đ</h4>
            </div>
            <%
                int quantity = 1;
                if (cart != null) {
                    if (cart.get(p.getId()) != null) {
                        quantity = cart.get(p.getId()).getQuantity() + 1;
                    }
                } else {
                    quantity = p.getQuantity();
                }
            %>
            <a href ="<%=url%>/cartController?id=<%=p.getId()%>&quantity=<%=quantity%>"><button onclick="themvaogiohang(this)" style="cursor: pointer"><i class="fa-solid fa-cart-shopping cart"></i></button></a>
        </div>
        <%
                }
            }
        %>
    </div>
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
        <%ArrayList<Products> newProducts = (ArrayList<Products>) request.getAttribute("newProducts");
            if (!newProducts.isEmpty() && newProducts != null) {
                for (Products pNP : newProducts) {%>
        <div class="pro">
            <%--            <img src="<%=url%><%=(newProducts.getImages().isEmpty())?"":newProducts.getImages()%>">--%>
            <div class="des">
                <span><%=pNP.getCategory().getName()%></span>
                <h5><%=pNP.getName()%></h5>
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h4><%=pNP.getPrice()%>đ</h4>
            </div>
            <%
                int quantity = 1;
                if (cart != null) {
                    if (cart.get(pNP.getId()) != null) {
                        quantity = cart.get(pNP.getId()).getQuantity() + 1;
                    }
                } else {
                    quantity = pNP.getQuantity();
                }
            %>
            <a href ="<%=url%>/cartController?id=<%=pNP.getId()%>&quantity=<%=quantity%>"><button onclick="themvaogiohang(this)" style="cursor: pointer"><i class="fa-solid fa-cart-shopping cart"></i></button></a>
        </div>
        <%
                }
            }
        %>
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
<script>
    var idCateCurrent = 0;
    var backProduct = 0;
    $(document).ready(function () {
        // ẩn hiện danh mục
        $('#cate').click(function () {
            var typeChair = $('#typeChair');
            if (typeChair.css("display") === "none") {
                typeChair.css("display", "block");
            } else {
                typeChair.css("display", "none");
            }
        })
        $('.lt').click(function () {
            var unCheckedRadio = $('input[type="radio"][name="price"]:checked, input[type="radio"][name="color"]:checked, input[type="radio"][name="material"]:checked');
            unCheckedRadio.prop('checked', false);
            if (backProduct === idCateCurrent) {
                $(this).css('color', 'black');
                loadProduct();
                backProduct = 0;
                idCateCurrent = 0;
            } else {
                $('.lt').css('color', '');
                $(this).css('color', '#f68e2e')
                backProduct = idCateCurrent;
            }
        })
    });
    function loadMore() {
        var count = document.getElementsByClassName("product").length;
        $.ajax({
            url: "loadMore",
            method: "GET",
            data: {
                exits: count,
                idCate: idCateCurrent
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
            },
        });
    }

    function loadProductByIdCate(idCate) {
        document.getElementById("loadMore").classList.remove("d-none")
        document.getElementById("exits").classList.add("d-none");
        $.ajax({
            url: "loadProductByIdCate",
            method: "GET",
            data: {
                cid: idCate
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML = data;
            },
        });
        idCateCurrent = idCate;
    }

    function loadProduct() {
        document.getElementById("loadMore").classList.remove("d-none")
        document.getElementById("exits").classList.add("d-none");
        $.ajax({
            url: "loadProduct",
            method: "GET",
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML = data;
            },
        });
    }
    function displaySelectedImage(input) {
        var fileInput = input;
        var selectedFile = fileInput.files[0];
        var reader = new FileReader();

        reader.onload = function (e) {
            // Tìm img tương ứng trong phạm vi cha của input
            var imgElement = input.parentElement.querySelector('.selectedImage');
            imgElement.classList.remove("d-none");
            imgElement.src = e.target.result;
        };

        if (selectedFile) {
            reader.readAsDataURL(selectedFile);
        }
    }

    function addInput() {
        var container = document.getElementById('image');
        var newInput = document.createElement('div');
        newInput.className = 'mb-3 d-flex align-items-center';
        newInput.innerHTML = `<img src="" class="card-img-top img_p_cart selectedImage me-2 d-none" alt="..."/> <input type="file" name ="image" class="form-control imageInput" onchange="displaySelectedImage(this)" style ="height:40px"> <button type ="button" class="btnAdd bgcolor bd-full ms-2 remove" onclick="removeInput(this)" style ="height:40px"><i class="fa fa-minus-circle text-color" aria-hidden="true" title="Xóa hình ảnh" ></i></button>`;
        container.appendChild(newInput);
    }
    function removeInput(button) {
        var container = document.getElementById('image');
        var divToRemove = button.parentNode; // Lấy đến div chứa nút xóa
        container.removeChild(divToRemove);
    }
    function innerCarousel() {
        $.ajax({
            type: "GET",
            url: "loadCarousel",
            success: function (data) {
                var htmlData = data.htmlData;
                var container = document.getElementById('image');
                container.innerHTML = "";
                for (var i = 0; i < htmlData.length; i++) {
                    var c = htmlData[i];
                    var newInput = document.createElement('div');
                    newInput.className = 'mb-3 d-flex align-items-center';
                    newInput.innerHTML = `<img src="image/Carousel/${c}"" class="card-img-top img_p_cart me-2" alt="..."/> <input type="text" class="form-control " name="imageAvai" value="image/Carousel/${c}" style ="height:40px"> <button type="button" class="btnAdd bgcolor bd-full ms-2  remove" style ="height:40px" onclick="removeInput(this)"><i class="fa fa-minus-circle text-color" aria-hidden="true" title="Xóa hình ảnh"></i></button>`;
                    container.appendChild(newInput);
                }
            },
            error: function () {
                console.error("Không thể tải chi tiết sản phẩm");
            }
        });
    };
    function editCarousel() {
        var formData = new FormData();
        var fileInputs = document.getElementsByName('image');
        for (var i = 0; i < fileInputs.length; i++) {
            var fileInput = fileInputs[i];
            formData.append('image', fileInput.files[0]);
        }
        var imgAvai = document.getElementsByName("imageAvai");
        for (var i = 0; i < imgAvai.length; i++) {
            formData.append('imageAvai', imgAvai[i].value);
        }
        $.ajax({
            url: 'editCarousel',
            type: 'post',
            data: formData,
            contentType: false,
            processData: false,
            success: function(data) {
                alert(data.res);
                location.reload();
            },
            error: function(error) {
                console.error("Xảy ra lỗi:", error);
            }
        });
    }
</script>
</body>
</html>
