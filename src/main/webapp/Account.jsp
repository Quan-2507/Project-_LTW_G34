<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 16/01/2024
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BoBa Tea</title>
    <link rel="icon" href="img/logo/snapedit_1699446793064.png">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
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
        background: #7e5730;

    }
</style>
<jsp:include page="header.jsp"></jsp:include>
<section id="page-banner" class="user-header">

    <!--    <h2>#ThankYou</h2>-->

    <!--    <p>Thank you for choosing us! </p>-->

</section>

<section id="page-header">
    <div class="container">
        <ul class="breadcrumb" aria-label="breadcrumbs">
            <li><a href="<%= request.getContextPath() %>/home">Trang chủ</a></li>
            <li class="active"><a href="Account.jsp">Tài khoản</a></li>
        </ul>
        <h1></h1>
    </div>
</section>

<div class="container light-style flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-4">
        Điều chỉnh tài khoản
    </h4>
    <div class="card overflow-hidden">
        <div class="row no-gutters row-bordered row-border-light">
            <div class="col-md-3 pt-0">
                <div class="list-group list-group-flush account-settings-links">
                    <a class="list-group-item list-group-item-action active" data-toggle="list"
                       href="#account-general">Tổng quan</a>
                    <a class="list-group-item list-group-item-action" data-toggle="list"
                       href="#account-cart">Đơn hàng của bạn</a>
                    <a class="list-group-item list-group-item-action" data-toggle="list"
                       onclick="window.location.href='doimatkhau.html';">Đổi mật khẩu</a>
                    <a class="list-group-item list-group-item-action" data-toggle="list"
                       href="#account-info">Thông tin cá nhân</a>
                    <a class="list-group-item list-group-item-action" data-toggle="list"
                       href="#account-social-links">Mạng xã hội</a>
                    <a class="list-group-item list-group-item-action" data-toggle="list"
                       href="#account-connections">Liên kết</a>
                    <a class="list-group-item list-group-item-action" data-toggle="list"
                       href="#account-notifications">Thông báo</a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="tab-content">
                    <div class="tab-pane fade active show" id="account-general">
                        <!--                        <div class="card-body media align-items-center">-->
                        <!--                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt-->
                        <!--                                 class="d-block ui-w-80">-->
                        <!--                            <div class="media-body ml-4">-->
                        <!--                                <label class="btn btn-outline-primary">-->
                        <!--                                    Đăng tải ảnh mới-->
                        <!--                                    <input type="file" class="account-settings-fileinput">-->
                        <!--                                </label> &nbsp;-->
                        <!--                                <button type="button" class="btn btn-default md-btn-flat">Reset</button>-->
                        <!--                                <div class="text-light small mt-1">Allowed JPG, GIF or PNG. Max size of 800K</div>-->
                        <!--                            </div>-->
                        <!--                        </div>-->
                        <hr class="border-light m-0">
                        <div class="card-body">
                            <div class="form-group">
                                <label class="form-label"> </label>
                                <input type="text" class="form-control mb-1" value="username">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Tên</label>
                                <input type="text" class="form-control" value="name">
                            </div>
                            <div class="form-group">
                                <label class="form-label">E-mail</label>
                                <input type="text" class="form-control mb-1" value="">
                                <div class="alert alert-warning mt-3">
                                    Your email is not confirmed. Please check your inbox.<br>
                                    <a href="javascript:void(0)">Resend confirmation</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Địa chỉ</label>
                                <input type="text" class="form-control" value="K3/14C">
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="account-cart">
                        <section>
                            <div id="wrapper">
                                <div class="tabs">
                                    <ul class="nav-tabs">
                                        <li class="active"><a href="#All">Tất cả</a></li>
                                        <li><a href="#Wait">Chờ thanh toán</a></li>
                                        <li><a href="#Deli">Vận chuyển</a></li>
                                        <li><a href="#Fin">Hoàn thành</a></li>
                                        <li><a href="#Canc">Đã huỷ</a></li>
                                    </ul>
                                    <div class="tab-content">

                                        <!-- Tất cả -->

                                        <div id="All" class="tab-content-item">
                                            <section class="section-p1 cart">
                                                <table width="100%">
                                                    <thead>
                                                    <tr>
                                                        <td>THỜI GIAN ĐẶT</td>
                                                        <td>HÌNH ẢNH</td>
                                                        <td>SẢN PHẨM</td>
                                                        <td>SIZE</td>
                                                        <td>SỐ LƯỢNG</td>
                                                        <td>TỔNG CỘNG</td>
                                                        <td>TRẠNG THÁI</td>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>13/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Hoàn thành</td>
                                                    </tr>
                                                    <tr>
                                                        <td>12/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Chờ thanh toán</td>
                                                    </tr>
                                                    <tr>
                                                        <td>11/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Đang vận chuyển</td>
                                                    </tr>
                                                    <tr>
                                                        <td>11/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Đã huỷ</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </section>
                                        </div>

                                        <!-- Chờ thanh toán -->

                                        <div id="Wait" class="tab-content-item">
                                            <section class="section-p1 cart">
                                                <table width="100%">
                                                    <thead>
                                                    <tr>
                                                        <td>THỜI GIAN ĐẶT</td>
                                                        <td>HÌNH ẢNH</td>
                                                        <td>SẢN PHẨM</td>
                                                        <td>SIZE</td>
                                                        <td>SỐ LƯỢNG</td>
                                                        <td>TỔNG CỘNG</td>
                                                        <td>TRẠNG THÁI</td>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>12/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Chờ thanh toán</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </section>
                                        </div>

                                        <!-- Vận chuyển -->

                                        <div id="Deli" class="tab-content-item">
                                            <section class="section-p1 cart">
                                                <table width="100%">
                                                    <thead>
                                                    <tr>
                                                        <td>THỜI GIAN ĐẶT</td>
                                                        <td>HÌNH ẢNH</td>
                                                        <td>SẢN PHẨM</td>
                                                        <td>SIZE</td>
                                                        <td>SỐ LƯỢNG</td>
                                                        <td>TỔNG CỘNG</td>
                                                        <td>TRẠNG THÁI</td>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>13/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Đang vận chuyển</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </section>
                                        </div>

                                        <!-- Hoàn thành -->

                                        <div id="Fin" class="tab-content-item">
                                            <section class="section-p1 cart">
                                                <table width="100%">
                                                    <thead>
                                                    <tr>
                                                        <td>THỜI GIAN ĐẶT</td>
                                                        <td>HÌNH ẢNH</td>
                                                        <td>SẢN PHẨM</td>
                                                        <td>SIZE</td>
                                                        <td>SỐ LƯỢNG</td>
                                                        <td>TỔNG CỘNG</td>
                                                        <td>TRẠNG THÁI</td>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>13/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Hoàn thành</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </section>
                                        </div>

                                        <!-- Đã huỷ -->

                                        <div id="Canc" class="tab-content-item">
                                            <section class="section-p1 cart">
                                                <table width="100%">
                                                    <thead>
                                                    <tr>
                                                        <td>THỜI GIAN HUỶ</td>
                                                        <td>HÌNH ẢNH</td>
                                                        <td>SẢN PHẨM</td>
                                                        <td>SIZE</td>
                                                        <td>SỐ LƯỢNG</td>
                                                        <td>TỔNG CỘNG</td>
                                                        <td>TRẠNG THÁI</td>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>11/11/2023</td>
                                                        <td><img src="img/products/trà%20sữa/matcha.jpeg" alt="">
                                                        </td>
                                                        <td>Trà sữa matcha</td>
                                                        <td>M</td>
                                                        <td>1</td>
                                                        <td>25.000đ</td>
                                                        <td>Đã huỷ</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </section>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="tab-pane fade" id="account-change-password">
                        <div class="card-body pb-2">
                            <div class="form-group">
                                <label class="form-label">Mật khẩu hiện tại</label>
                                <input type="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Mật khẩu mới</label>
                                <input type="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Nhập lại mật khẩu mới</label>
                                <input type="password" class="form-control">
                            </div>
                        </div>
                        <div class="text-right mt-3">
                            <button type="button" class="btn btn-primary">Lưu thay đổi</button>&nbsp;
                            <button type="button" class="btn btn-default">Huỷ</button>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="account-info">
                        <div class="card-body pb-2">
                            <div class="form-group">
                                <label class="form-label">Bio</label>
                                <textarea class="form-control"
                                          rows="5">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris nunc arcu, dignissim sit amet sollicitudin iaculis, vehicula id urna. Sed luctus urna nunc. Donec fermentum, magna sit amet rutrum pretium, turpis dolor molestie diam, ut lacinia diam risus eleifend sapien. Curabitur ac nibh nulla. Maecenas nec augue placerat, viverra tellus non, pulvinar risus.</textarea>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Birthday</label>
                                <input type="text" class="form-control" value="May 3, 1995">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Country</label>
                                <select class="custom-select">
                                    <option>USA</option>
                                    <option selected>Canada</option>
                                    <option>UK</option>
                                    <option>Germany</option>
                                    <option>France</option>
                                </select>
                            </div>
                        </div>
                        <hr class="border-light m-0">
                        <div class="card-body pb-2">
                            <h6 class="mb-4">Contacts</h6>
                            <div class="form-group">
                                <label class="form-label">Phone</label>
                                <input type="text" class="form-control" value="+0 (123) 456 7891">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Website</label>
                                <input type="text" class="form-control" value>
                            </div>
                        </div>
                        <div class="text-right mt-3">
                            <button type="button" class="btn btn-primary">Lưu thay đổi</button>&nbsp;
                            <button type="button" class="btn btn-default">Huỷ</button>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="account-social-links">
                        <div class="card-body pb-2">
                            <div class="form-group">
                                <label class="form-label">Twitter</label>
                                <input type="text" class="form-control" value="https://twitter.com/user">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Facebook</label>
                                <input type="text" class="form-control" value="https://www.facebook.com/user">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Google+</label>
                                <input type="text" class="form-control" value>
                            </div>
                            <div class="form-group">
                                <label class="form-label">LinkedIn</label>
                                <input type="text" class="form-control" value>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Instagram</label>
                                <input type="text" class="form-control" value="https://www.instagram.com/user">
                            </div>
                        </div>
                        <div class="text-right mt-3">
                            <button type="button" class="btn btn-primary">Lưu thay đổi</button>&nbsp;
                            <button type="button" class="btn btn-default">Huỷ</button>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="account-connections">
                        <div class="card-body">
                            <button type="button" class="btn btn-twitter">Connect to
                                <strong>Twitter</strong></button>
                        </div>
                        <hr class="border-light m-0">
                        <div class="card-body">
                            <h5 class="mb-2">
                                <a href="javascript:void(0)" class="float-right text-muted text-tiny"><i
                                        class="ion ion-md-close"></i> Remove</a>
                                <i class="ion ion-logo-google text-google"></i>
                                You are connected to Google:
                            </h5>
                            <a href="/cdn-cgi/l/email-protection" class="__cf_email__"
                               data-cfemail="f9979498818e9c9595b994989095d79a9694">[email&#160;protected]</a>
                        </div>
                        <hr class="border-light m-0">
                        <div class="card-body">
                            <button type="button" class="btn btn-facebook">Connect to
                                <strong>Facebook</strong></button>
                        </div>
                        <hr class="border-light m-0">
                        <div class="card-body">
                            <button type="button" class="btn btn-instagram">Connect to
                                <strong>Instagram</strong></button>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="account-notifications">
                        <div class="card-body pb-2">
                            <h6 class="mb-4">Activity</h6>
                            <div class="form-group">
                                <label class="switcher">
                                    <input type="checkbox" class="switcher-input" checked>
                                    <span class="switcher-indicator">
                                            <span class="switcher-yes"></span>
                                            <span class="switcher-no"></span>
                                        </span>
                                    <span class="switcher-label">Email me when someone comments on my article</span>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="switcher">
                                    <input type="checkbox" class="switcher-input" checked>
                                    <span class="switcher-indicator">
                                            <span class="switcher-yes"></span>
                                            <span class="switcher-no"></span>
                                        </span>
                                    <span class="switcher-label">Email me when someone answers on my forum
                                            thread</span>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="switcher">
                                    <input type="checkbox" class="switcher-input">
                                    <span class="switcher-indicator">
                                            <span class="switcher-yes"></span>
                                            <span class="switcher-no"></span>
                                        </span>
                                    <span class="switcher-label">Email me when someone follows me</span>
                                </label>
                            </div>
                        </div>
                        <hr class="border-light m-0">
                        <div class="card-body pb-2">
                            <h6 class="mb-4">Application</h6>
                            <div class="form-group">
                                <label class="switcher">
                                    <input type="checkbox" class="switcher-input" checked>
                                    <span class="switcher-indicator">
                                            <span class="switcher-yes"></span>
                                            <span class="switcher-no"></span>
                                        </span>
                                    <span class="switcher-label">News and announcements</span>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="switcher">
                                    <input type="checkbox" class="switcher-input">
                                    <span class="switcher-indicator">
                                            <span class="switcher-yes"></span>
                                            <span class="switcher-no"></span>
                                        </span>
                                    <span class="switcher-label">Weekly product updates</span>
                                </label>
                            </div>
                            <div class="form-group">
                                <label class="switcher">
                                    <input type="checkbox" class="switcher-input" checked>
                                    <span class="switcher-indicator">
                                            <span class="switcher-yes"></span>
                                            <span class="switcher-no"></span>
                                        </span>
                                    <span class="switcher-label">Weekly blog digest</span>
                                </label>
                            </div>
                        </div>
                        <div class="text-right mt-3">
                            <button type="button" class="btn btn-primary">Lưu thay đổi</button>&nbsp;
                            <button type="button" class="btn btn-default">Huỷ</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--    <div class="text-right mt-3">-->
    <!--        <button type="button" class="btn btn-primary">Lưu thay đổi</button>&nbsp;-->
    <!--        <button type="button" class="btn btn-default">Huỷ</button>-->
    <!--    </div>-->
</div>



<jsp:include page="footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.6.2.js"></script>

<script src="js/script.js"></script>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
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
</body>
</html>