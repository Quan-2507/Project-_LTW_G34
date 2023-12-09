<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/27/2023
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section id="header">
    <a href="Html/home.html" style="max-width: 100px"><img src="img/logo/snapedit_1699446793064.png" class="logo" alt=""></a>
    <div>
        <ul id="navbar">
            <li><a class="active" href="Html/home.html">TRANG CHỦ</a></li>
            <li><a href="Html/milktea.html">THỨC UỐNG</a>
            </li>
            <li><a href="Html/blog.html">KHUYẾN MÃI</a></li>
            <li><a href="Html/about.html">VỀ CHÚNG TÔI</a></li>
            <li><a href="Html/contact.html">LIÊN HỆ</a></li>
            <li class="lg-bag">
                <form class="search">
                    <input type="text" placeholder="Search" class="search__input">
                    <button type="button" class="search__btn">
                        <a><i class="fa-solid fa-magnifying-glass"></i></a>
                    </button>
                </form>
            </li>
            <li class="lg-bag"><a href="Html/cart.html" onclick="showcart()"><i class="fa-solid fa-bag-shopping"></i></a></li>
            <li class="lg-bag"><a href="Html/signup-signin.html"><i class="fa-regular fa-user"></i></a></li>
            <a href="#" id="close"><i class="fa fa-times" aria-hidden="true"></i></a>
        </ul>
    </div>
    <div id="mobile">
        <form class="search">
            <input type="text" placeholder="Search" class="search__input">
            <button type="button" class="search__btn">
                <a><i class="fa-solid fa-magnifying-glass"></i></a>
            </button>
        </form>
        <a href="Html/cart.html"><i class="fa-solid fa-bag-shopping"></i></a>
        <i id="bar" class="fa fa-outdent"></i>
    </div>
</section>