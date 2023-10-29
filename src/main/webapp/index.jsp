<%@ page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>MilkStores – Thế giới trà sữa</title>
    <meta name='keywords' content='MilkStores – Thế giới trà sữa'/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">

    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&display=swap" rel="stylesheet">
    <link href="css/style.css?v=<?=$full_me_time_en ?>" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/script218.js?v=<?=$full_me_time_en ?>"></script>

</head>
<script>
    $(function(){
        var hei = $(".dv-ul-menu > ul").height();
        $(".dv-ul-menu ul ul.sub-2").css("min-height", hei + 2);
        //end
    })
</script>
<script>
    $(document).ready(function(){
        // hide #back-top first
        $("#back-top").hide();

        // fade in #back-top
        $(function () {
            $(window).scroll(function () {
                if ($(this).scrollTop() > 100) {
                    $('#back-top').fadeIn();
                } else {
                    $('#back-top').fadeOut();
                }
            });

            // scroll body to 0px on click
            $('#back-top a').click(function () {
                $('body,html').animate({
                    scrollTop: 0
                }, 800);
                return false;
            });
        });

    });
</script>
<body>
<div class="dv-content-full">
    <article><section></section></article>
    <jsp:include page="header/header.jsp"></jsp:include>
    <jsp:include page="banner_top.jsp"></jsp:include>
    <div class="customer-service ">
        <div class="support clearfix pagewrap">
            <div class="col-lg-12 flex">
                <div class="col-lg-3">
                    <div class="media ">
                        <div class="box-icon pull-left">
                            <i class="fa fa-truck"></i>
                        </div>
                        <div class="media-body">
                            <h4>MIỄN PHÍ VẬN CHUYỂN</h4>
                            <p><em>Đặt hàng trên 100.000 đ</em></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="media ">
                        <div class="box-icon pull-left">
                            <i class="fa fa-gift"></i>
                        </div>
                        <div class="media-body">
                            <h4>GIỎ QUÀ ĐẶC BIỆT</h4>
                            <p><em>Tặng món quà hoàn hảo</em></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="media ">
                        <div class="box-icon pull-left">
                            <i class="fa fa-calendar-o"></i>
                        </div>
                        <div class="media-body">
                            <h4>KHUYẾN MÃI ĐẶC BIỆT</h4>
                            <p><em>Sed ut perspiciatis unde</em></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="media ">
                        <div class="box-icon pull-left">
                            <i class="fa fa-comments-o"></i>
                        </div>
                        <div class="media-body">
                            <h4>CHĂM SÓC KHÁCH HÀNG 24/7</h4>
                            <p><em>Gọi ngay: <?=$full_me_hotline ?></em></p>

                        </div>
                    </div>
                </div>
            </div>
            <div class="clr"></div>
        </div>
    </div>
    <section class="dv-home-sanpham" style="margin-top: -50px;">
        <div class="pagewrap">
            <div class="title_home wow flipInX">
                <h2 class="tiltle">Đồ uống khuyến mãi</h2>
            </div>
            <div class="pro_home_id flex">
                <ul>
                    <li><a href="trasua_view.jsp"><img src="delete/sanpham/sp1.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Okinawa Coffee Milk Tea</a></h3>
                    <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                    <span class="css-1h3p11h">-12%</span>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
                <ul>
                    <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp2.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Okinawa Oreo Cream Milk Tea</a></h3>
                    <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                    <span class="css-1h3p11h">-12%</span>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
                <ul>
                    <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp3.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Trà Sữa Xoài Trân Châu Đen</a></h3>
                    <h4><span>60.000 <sup>₫</sup></span> 51.000 <sup>₫</sup></h4>
                    <span class="css-1h3p11h">-9%</span>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
                <ul>
                    <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp4.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Trà Sữa Okinawa</a></h3>
                    <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                    <span class="css-1h3p11h">-7%</span>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
                <ul>
                    <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp5.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Trà Sữa Matcha Đậu Đỏ</a></h3>
                    <h4>65.000 <sup>₫</sup></h4>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
                <ul>
                    <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp6.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Trà sữa Oolong 3J</a></h3>
                    <h4>55.000 <sup>₫</sup></h4>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
                <ul>
                    <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp7.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Trà Sữa Pudding Đậu Đỏ</a></h3>
                    <h4>51.000 <sup>₫</sup></h4>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
                <ul>
                    <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp8.png"/></a></li>
                    <h3><a href="trasua_view.jsp">Trà Sữa Chocolate</a></h3>
                    <h4>51.000 <sup>₫</sup></h4>
                    <p class="p-star">
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star"></span>
                        <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                    </p>
                    <?php include"icon-tooltip.jsp";?>
                </ul>
            </div>
            <div class="clr"></div>
            <div class="qodef-m-button clear align_center">
                <a class="qodef-shortcode qodef-m  qodef-button qodef-layout--textual qodef-html--link" href="index.jsp?page=trasua" target="_self"> <span class="qodef-m-text">Xem tất cả sản phẩm</span> <span class="qodef-m-icon"> <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="40px" height="40px" viewBox="0 0 40 40" enable-background="new 0 0 40 40" xml:space="preserve"><circle class="qodef-arc-1" cx="20" cy="20" r="19"></circle><circle class="qodef-arc-2" cx="20" cy="20" r="19"></circle></svg> </span></a>
            </div>
            <div class="clr"></div>
        </div>
    </section>
    <section class="dv-home-column">
        <div class="pagewrap">
            <div class="home-left tin_right">
                <div class="box_right_pro_view">
                    <div class="title_right_pro_view">Danh mục sản phẩm</div>
                    <ul>
                        <li class="vertical-menu vertical-menu-1"><a href="index.jsp?page=sanpham" title="">Trà truyền thống</a>
                            <i class="fa fa-plus-square-o" ></i>
                            <i class="fa fa-minus-square-o" ></i>
                            <ul class="vertical-menu-sub sub-3" style="display: none;">
                                <div class="col-mn-3">
                                    <li><a href="index.jsp?page=sanpham" title="">Hồng trà</a></li>
                                    <li><a href="index.jsp?page=sanpham" title="">Trà ô long</a></li>
                                    <li><a href="index.jsp?page=sanpham" title="">Trà hoa nhài</a></li>
                                </div>
                                <div class="clr"></div>
                            </ul>
                        </li>
                        <li class="vertical-menu vertical-menu-2"><a href="index.jsp?page=sanpham" title="">Trà sữa trái cây</a>
                            <i class="fa fa-plus-square-o" ></i>
                            <i class="fa fa-minus-square-o" ></i>
                            <ul class="vertical-menu-sub sub-3" style="display: none;">
                                <div class="col-mn-3">
                                    <li><a href="index.jsp?page=sanpham" title="">Trà xanh vị cam</a></li>
                                    <li><a href="index.jsp?page=sanpham" title="">Trà ô mai đào</a></li>
                                    <li><a href="index.jsp?page=sanpham" title="">Trà xanh vị ổi</a></li>
                                </div>
                                <div class="clr"></div>
                            </ul>
                        </li>
                        <li class="vertical-menu vertical-menu-3"><a href="index.jsp?page=sanpham" title="">Trà sữa Đài Loan</a>
                            <i class="fa fa-plus-square-o" ></i>
                            <i class="fa fa-minus-square-o" ></i>
                            <ul class="vertical-menu-sub sub-3" style="display: none;">
                                <div class="col-mn-3">
                                    <li><a href="index.jsp?page=sanpham" title="">Hồng trà sữa</a></li>
                                    <li><a href="index.jsp?page=sanpham" title="">Trà sữa mật ong</a></li>
                                    <li><a href="index.jsp?page=sanpham" title="">Trà sữa hokaido</a></li>
                                </div>
                                <div class="clr"></div>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="box_right_pro_view">
                    <div class="title_right_pro_view" style="background: #409f3e;">ƯU ĐÃI ĐẶC BIỆT</div>
                    <div class="marquee">
                        <div class="blog-item">
                            <div class="img-box">
                                <a href="index.jsp?page=sanpham_view" class="open-post">
                                    <img class="img-fluid" src="img/delete/sanpham/sp1.png" alt="">
                                </a>
                            </div>
                            <div class="text-box">
                                <a href="index.jsp?page=sanpham_view" class="">
                                    <h5>Okinawa Coffee Milk Tea</h5>
                                </a>
                                <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                            </div>
                        </div>
                        <div class="blog-item">
                            <div class="img-box">
                                <a href="index.jsp?page=sanpham_view" class="open-post">
                                    <img class="img-fluid" src="img/delete/sanpham/sp2.png" alt="">
                                </a>
                            </div>
                            <div class="text-box">
                                <a href="index.jsp?page=sanpham_view" class="">
                                    <h5>Okinawa Oreo Cream Milk Tea</h5>
                                </a>
                                <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                            </div>
                        </div>
                        <div class="blog-item">
                            <div class="img-box">
                                <a href="index.jsp?page=sanpham_view" class="open-post">
                                    <img class="img-fluid" src="img/delete/sanpham/sp3.png" alt="">
                                </a>
                            </div>
                            <div class="text-box">
                                <a href="index.jsp?page=sanpham_view" class="">
                                    <h5>Trà Sữa Xoài Trân Châu Đen</h5>
                                </a>
                                <h4><span>60.000 <sup>₫</sup></span> 51.000 <sup>₫</sup></h4>
                            </div>
                        </div>
                        <div class="blog-item">
                            <div class="img-box">
                                <a href="index.jsp?page=sanpham_view" class="open-post">
                                    <img class="img-fluid" src="img/delete/sanpham/sp4.png" alt="">
                                </a>
                            </div>
                            <div class="text-box">
                                <a href="index.jsp?page=sanpham_view" class="">
                                    <h5>Trà Sữa Okinawa</h5>
                                </a>
                                <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box_right_pro_view">
                    <a href="#"><img src="img/delete/trangchu/4.png"></a>
                </div>
                <div class="box_right_pro_view">
                    <div class="title_right_pro_view">Nhận khuyến mãi</div>
                    <div class="box-email">
                        <h4>Đăng ký để nhận thông tin về sản phẩm và phiếu giảm giá</h4>
                        <form class="dt-sc-subscribe-frm" name="frmsubscribe" action="#" method="post">
                            <input type="email" name="dt_mc_emailid" required="required" placeholder="Nhập email của bạn...">
                            <input type="submit" name="mc_submit" value="Đăng ký">
                        </form>
                    </div>
                </div>
            </div>
            <div class="home-right">
                <section class="awe-section-4">
                    <div class="wrap_banner">
                        <div class="col-sm-6 img-left">
                            <a class="img1" href="#" title="Banner 1">
                                <img class="lazyload loaded" src="img/delete/trangchu/1.png" data-src="" alt="Banner 1" data-was-processed="true">
                            </a>
                            <a class="img1" href="#" title="Banner 1">
                                <img class="lazyload loaded" src="img/delete/trangchu/2.png" data-src="" alt="Banner 1" data-was-processed="true">
                            </a>
                        </div>
                        <div class="col-sm-6 img-right">
                            <a class="img1" href="#" title="Banner 2">
                                <img class="lazyload loaded" src="img/delete/trangchu/3.png" data-src="" alt="Banner 2" data-was-processed="true">
                            </a>
                        </div>
                    </div>
                    <div class="clr"></div>
                </section>
                <section class="dv-home-sanpham">
                    <div class="title_home wow flipInX">
                        <h2 class="tiltle">Sản phẩm nổi bật</h2>
                    </div>
                    <div class="pro_home_id flex">
                        <ul>
                            <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp1.png"/></a></li>
                            <h3><a href="trasua_view.jsp">Okinawa Coffee Milk Tea</a></h3>
                            <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                            <span class="css-1h3p11h">-12%</span>
                            <p class="p-star">
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                            </p>
                            <?php include"icon-tooltip.jsp";?>
                        </ul>
                        <ul>
                            <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp2.png"/></a></li>
                            <h3><a href="trasua_view.jsp">Okinawa Oreo Cream Milk Tea</a></h3>
                            <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                            <span class="css-1h3p11h">-12%</span>
                            <p class="p-star">
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                            </p>
                            <?php include"icon-tooltip.jsp";?>
                        </ul>
                        <ul>
                            <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp3.png"/></a></li>
                            <h3><a href="trasua_view.jsp">Trà Sữa Xoài Trân Châu Đen</a></h3>
                            <h4><span>60.000 <sup>₫</sup></span> 51.000 <sup>₫</sup></h4>
                            <span class="css-1h3p11h">-9%</span>
                            <p class="p-star">
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                            </p>
                            <?php include"icon-tooltip.jsp";?>
                        </ul>
                        <ul>
                            <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp4.png"/></a></li>
                            <h3><a href="trasua_view.jsp">Trà Sữa Okinawa</a></h3>
                            <h4><span>65.000 <sup>₫</sup></span> 57.000 <sup>₫</sup></h4>
                            <span class="css-1h3p11h">-7%</span>
                            <p class="p-star">
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                            </p>
                            <?php include"icon-tooltip.jsp";?>
                        </ul>
                        <ul>
                            <li><a href="index.jsp?page=trasua_view"><img src="img/delete/sanpham/sp5.png"/></a></li>
                            <h3><a href="index.jsp?page=trasua_view">Trà Sữa Matcha Đậu Đỏ</a></h3>
                            <h4>65.000 <sup>₫</sup></h4>
                            <p class="p-star">
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                            </p>
                            <?php include"icon-tooltip.jsp";?>
                        </ul>
                        <ul>
                            <li><a href="trasua_view.jsp"><img src="img/delete/sanpham/sp6.png"/></a></li>
                            <h3><a href="trasua_view.jsp">Trà sữa Oolong 3J</a></h3>
                            <h4>55.000 <sup>₫</sup></h4>
                            <p class="p-star">
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star"></span>
                                <span data-sao="0" data="1200" class="fa fa-star-o"></span>
                            </p>
                            <?php include"icon-tooltip.jsp";?>
                        </ul>
                    </div>
                    <div class="clr"></div>
                    <div class="qodef-m-button clear align_center">
                        <a class="qodef-shortcode qodef-m  qodef-button qodef-layout--textual qodef-html--link" href="index.jsp?page=trasua" target="_self"> <span class="qodef-m-text">Xem tất cả sản phẩm</span> <span class="qodef-m-icon"> <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="40px" height="40px" viewBox="0 0 40 40" enable-background="new 0 0 40 40" xml:space="preserve"><circle class="qodef-arc-1" cx="20" cy="20" r="19"></circle><circle class="qodef-arc-2" cx="20" cy="20" r="19"></circle></svg> </span></a>
                    </div>
                    <div class="clr"></div>
                </section>
            </div>
            <div class="clr"></div>
        </div>
    </section>

    <script>
        $('.marquee').marquee({
            duration: 19000,
            gap: 0,
            delayBeforeStart: 0,
            direction: 'up',
            duplicated: true,
            pauseOnHover: true,
            startVisible: true
        });
    </script>
<?php include"footer.jsp";?></div>
</body>
</html>