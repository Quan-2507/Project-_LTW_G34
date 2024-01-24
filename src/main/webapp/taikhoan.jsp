<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22/1/2024
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CRUD Operations</title>
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="Admin/css/style.css">

    <title>CRUD Operations</title>

</head>
<body>
<div class="container">
    <nav>
        <ul>
            <li><a href="<%= request.getContextPath() %>/home" class="logo">
                <img src="../images/snapedit_1699446793064.png">
                <span class="nav-item">Trang chủ</span>
            </a></li>
            <li><a href="<%= request.getContextPath() %>/taikhoan">
                <i class="fa-solid fa-users-gear"></i>
                <span class="nav-item">Quản lý User</span>
            </a></li>
            <li><a href="<%= request.getContextPath() %>/danhmuc">
                <i class="fa-solid fa-calendar"></i>
                <span class="nav-item">Danh mục</span>
            </a></li>
            <li><a href="<%= request.getContextPath() %>/sanpham">
                <i class="fa-solid fa-mug-saucer"></i>
                <span class="nav-item">Sản phẩm</span>
            </a></li>
            <li><a href="<%= request.getContextPath() %>/hoadon">
                <i class="fa-solid fa-receipt"></i>
                <span class="nav-item">Hóa đơn</span>
            </a></li>
            <li><a href="../../html/signup-signin.html" class="logout">
                <i class="fa-solid fa-right-from-bracket"></i>
                <span class="nav-item">Đăng xuất</span>
            </a></li>
        </ul>
    </nav>
    <section class="main">
        <div class="main-top">
            <a href="<%= request.getContextPath() %>/admin"><h1 >Admin</h1></a>
        </div>
        <section class="attendance">
            <div class="attendance-list">
                <h1>Danh sách User</h1>
                <table class="table">
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>Họ và tên</td>
                        <td>Email</td>
                        <td>Địa chỉ</td>
                        <td>Chi tiết</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>21130495</td>
                        <td>Trần Minh Quân</td>
                        <td>21130495@gmail.com</td>
                        <td>Đồng Nai</td>
                        <td>
                            <i class="fa-solid fa-plus"></i>
                            <i class="fa-solid fa-trash-can"></i>
                            <i class="fa-solid fa-pen-to-square"></i>
                        </td>
                    </tr>
                    <tr class="active">
                        <td>21130504</td>
                        <td>Kiều Thị Ngọc Qúy </td>
                        <td>21130495@gmail.com</td>
                        <td>Ninh Thuận</td>
                        <td>
                            <i class="fa-solid fa-plus"></i>
                            <i class="fa-solid fa-trash-can"></i>
                            <i class="fa-solid fa-pen-to-square"></i>
                        </td>
                    </tr>
                    <tr>
                        <td>21130461</td>
                        <td>Trần Thị Thiện Nhân</td>
                        <td>21130495@gmail.com</td>
                        <td>Bình Thuận</td>
                        <td>
                            <i class="fa-solid fa-plus"></i>
                            <i class="fa-solid fa-trash-can"></i>
                            <i class="fa-solid fa-pen-to-square"></i>
                        </td>
                    </tr>
                    <tr>
                        <td>21130122</td>
                        <td>Đặng Thanh Nhân</td>
                        <td>21130122@gmail.com</td>
                        <td>Bình Định</td>
                        <td>
                            <i class="fa-solid fa-plus"></i>
                            <i class="fa-solid fa-trash-can"></i>
                            <i class="fa-solid fa-pen-to-square"></i>
                        </td>
                    </tr>
                    <tr>
                        <td>21130567</td>
                        <td>Trịnh Thanh Sang</td>
                        <td>21130567@gmail.com</td>
                        <td>Bình Dương</td>
                        <td>
                            <i class="fa-solid fa-plus"></i>
                            <i class="fa-solid fa-trash-can"></i>
                            <i class="fa-solid fa-pen-to-square"></i>
                        </td>
                    </tr>
                    <tr>
                        <td>21130343</td>
                        <td>Lê Thành Quý</td>
                        <td>21130343@gmail.com</td>
                        <td>An Giang</td>
                        <td>
                            <i class="fa-solid fa-plus"></i>
                            <i class="fa-solid fa-trash-can"></i>
                            <i class="fa-solid fa-pen-to-square"></i>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </section>
    </section>
</div>
</body>
</html>
