<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22/1/2024
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="Admin/css/style.css">
    <script src="https://kit.fontawesome.com/263257cb2f.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <nav>
        <ul>
            <li><a href="<%= request.getContextPath() %>" class="logo">
                <img src="img/snapedit_1699446793064.png">
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
            <h1>Admin</h1>
        </div>
        <section class="attendance">
            <div class="attendance-list">
                <h1>Chi tiết Sản phẩm</h1>
                <table class="table">
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>Mô tả</td>
                        <td>Size</td>
                        <td>Giá</td>
                        <td>Chi tiết</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${productList}">
                        <tr>

                            <td>${product.id}</td>
                            <td>${product.description}</td>
                            <td>${product.size}</td>
                            <td>${product.price}đ</td>
                            <td>
                                <i class="fa-solid fa-plus"></i>
                                <i class="fa-solid fa-trash-can"></i>
                                <i class="fa-solid fa-pen-to-square"></i>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </section>
    </section>
</div>
</body>
</html>