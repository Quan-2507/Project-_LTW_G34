<div class="dv-header">
    <div class="dv-header-center">
        <div class="pagewrap flex">
            <div class="logo_top">
                <a href="index.php"><img src="delete/logo.png" alt="logo"/></a>
            </div>
            <div class="right-top">
                <!-- <div class="dangnhap_top">
                  <a href="index.php?page=dangnhap">
                    <i class="fa fa-user-o" ></i> Tài khoản
                  </a>
                </div> -->
                <div class="wishlist-box">
                    <a href="#">
                        <i class="fa fa-heart-o" ></i> <h3>Yêu thích</h3>
                    </a>
                </div>
                <div class="compare-box hidden-sm hidden-xs">
                    <a href="#">
                        <i class="fa fa-compress" ></i> <h3>So sánh</h3>
                    </a>
                </div>
                <div class="language">
                    <i class="fa fa-globe" ></i><a href="#">ENG</a> | <a href="#">VN</a>
                </div>
                <div class="giohang_top">
                    <a href="index.php?page=giohang">
                        <h3>Giỏ hàng<span>1 sản phẩm - 100.000đ</span></h3>
                        <i class="fa fa-shopping-bag" ></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="dv-header-bt">
        <div class="pagewrap flex">
            <div class="box_menu">
                <!--  -->
                <?php ob_start(); ?>
                <!--  -->
                <ul class="menu">
                    <li><a href="index.php" title="Trang chủ">Trang chủ</a></li>
                    <li><a href="index.php?page=gioithieu" title="Giới thiệu">Giới thiệu</a></li>
                    <li><a href="index.php?page=trasua" title="Menu trà sữa">Menu trà sữa <i class="fa fa-angle-down"></i></a>
                        <ul class="menu_child">
                            <li><span><a href="index.php?page=trasua">Trà truyền thống</a></span>
                                <ul>
                                    <li><a href="index.php?page=trasua" title="">Hồng trà</a></li>
                                    <li><a href="index.php?page=trasua" title="">Trà ô long</a></li>
                                    <li><a href="index.php?page=trasua" title="">Trà hoa nhài</a></li>
                                </ul>
                            </li>
                            <li><span><a href="index.php?page=trasua">Trà sữa trái cây</a></span>
                                <ul>
                                    <li><a href="index.php?page=trasua" title="">Trà xanh vị cam</a></li>
                                    <li><a href="index.php?page=trasua" title="">Trà ô mai đào</a></li>
                                    <li><a href="index.php?page=trasua" title="">Trà xanh vị ổi</a></li>
                                </ul>
                            </li>
                            <li><span><a href="index.php?page=trasua">Trà sữa Đài Loan</a></span>
                                <ul>
                                    <li><a href="index.php?page=trasua" title="">Hồng trà sữa</a></li>
                                    <li><a href="index.php?page=trasua" title="">Trà sữa mật ong</a></li>
                                    <li><a href="index.php?page=trasua" title="">Trà sữa hokaido</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="li_child"><a href="index.php?page=dichvu" title="Dịch vụ">Dịch vụ <i class="fa fa-angle-down"></i></a>
                        <ul>
                            <li><a href="index.php?page=dichvu_view" title="">Hướng dẫn mua hàng</a></li>
                            <li><a href="index.php?page=dichvu_view" title="">Bảo mật thông tin</a></li>

                            <li><a href="index.php?page=dichvu_view" title="">Miễn phí giao hàng</a></li>
                            <li><a href="index.php?page=dichvu_view" title="">Hướng dẫn thanh toán</a></li>

                        </ul>
                    </li>
                    <li><a href="index.php?page=tintuc" title="Tin tức">Tin tức</a></li>
                    <li class="li_child"><a href="#" title="Thư viện">Thư viện <i class="fa fa-angle-down"></i></a>
                        <ul>
                            <li><a href="index.php?page=hinhanh" title="Thư viện hình ảnh">Thư viện hình ảnh</a></li>
                            <li><a href="index.php?page=video" title="Thư viện video">Thư viện video</a></li>
                        </ul>
                    </li>
                    <li><a href="index.php?page=lienhe" title="Liên hệ">Liên hệ</a></li>
                </ul>
                <!--  -->
                <?php
  $menu_full = ob_get_contents();
  ob_end_clean();
  include "../../lib/menu.php";
?>
                <!--  -->
            </div>
            <div class="timkiem_top">
                <form action="" method="post">
                    <div class="search">
                        <a href="#" onclick="#" style="cursor:pointer">Nhập từ khóa tìm kiếm</a>
                        <input class="input_search" type="text" id="search" placeholder="Nhập từ khóa tìm kiếm">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="clr"></div>
</div>

<script type="text/javascript">
    $(function(){
        // this will get the full URL at the address bar
        var url = window.location.href;

        // passes on every "a" tag
        $(".menu a").each(function() {
            // checks if its the same on the address bar
            if(url == (this.href)) {
                $(this).closest("li").addClass("active");
            }
        });
    });
</script>