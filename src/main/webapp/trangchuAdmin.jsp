<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22/1/2024
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
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
        <div class="users">
            <div class="card">
                <img src="../images/snapedit_1699446793064.png">
                <h4>Doanh thu</h4>
                <p>122.234.000.000</p>
            </div>
            <div class="card">
                <img src="../images/snapedit_1699446793064.png">
                <h4>Vốn</h4>
                <p>78.120.000.000</p>
            </div>
            <div class="card">
                <img src="../images/snapedit_1699446793064.png">
                <h4>Lợi nhuận</h4>
                <p>44.114.000.000</p>
            </div>
        </div>
        <section class="attendance">
            <div class="attendance-list">
                <h1>Danh sách Admin</h1>
                <table class="table">
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>Họ và tên</td>
                        <td>Năm sinh</td>
                        <td>Chức vụ</td>
                        <td>Chi tiết</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="admin" items="${adminList}">
                        <tr>
                            <td>${admin.id}</td>
                            <td>${admin.name}</td>
                            <td>${admin.dateOfBirth}</td>
                            <td>${admin.position}</td>
                            <td>
                                    <%--                                <i class="fa-solid fa-plus"></i>--%>
                                    <%--                                <i class="fa-solid fa-trash-can"></i>--%>
                                    <%--                                <i class="fa-solid fa-pen-to-square"></i>--%>
                                <button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                                        onclick="confirmDelete(${user.id})"><i class="fas fa-trash-alt"></i>
                                </button>
                                <a href="${pageContext.request.contextPath}/editUser?id=${user.id}">
                                    <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"
                                            id="show-emp"
                                            data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i>
                                    </button>
                                </a>
                                <a href="${pageContext.request.contextPath}/addUser?id=${user.id}">
                                    <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"
                                            id="show-emp"
                                            data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i>
                                    </button>
                                </a>
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
