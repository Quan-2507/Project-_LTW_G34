var topH = 0;
if($(".dv-header-fixed-top").length){
    topH = $(".dv-header-fixed-top").height();
}
$(window).scroll(function () {
    if ($(this).scrollTop() > topH) {
        $('.dv-header-fixed').addClass("fixed");
    } else {
        $('.dv-header-fixed').removeClass("fixed");
    }
});
function SHOWHI_cls(obj, cls_a, cls_b, cls_all){
    if($(obj).hasClass("active")) {
        $(cls_a).removeClass("active");
        $(obj).removeClass("active");
        $(cls_all).hide();
    }
    else {
        $(cls_a).removeClass("active");
        $(obj).addClass("active");
        $(cls_all).hide();
        $(cls_b).show();
    }

    window.scrollTo(window.scrollX, window.scrollY - 1);
    window.scrollTo(window.scrollX, window.scrollY + 1);
}
function plus_minus(obj){
    var t = $(obj).closest(".quantity").find(".qty"),n=parseFloat(t.val()),r=parseFloat(t.attr("max")),i=parseFloat(t.attr("min")),s=t.attr("step");
    if(!n||n==""||n=="NaN")n=0;
    if(r==""||r=="NaN")r="";if(i==""||i=="NaN")i=0;
    if(s=="any"||s==""||s==undefined||parseFloat(s)=="NaN")s=1;
    $(obj).is(".plus")?r&&(r==n||n>r)?t.val(r):t.val(n+parseFloat(s)):i&&(i==n||n<i)?t.val(i):n>0&&t.val(n-parseFloat(s));
    t.trigger("change");
}
$(".plus").click(function(){
    plus_minus(this);
});
$(".minus").click(function(){
    plus_minus(this);
});

function LOAD_addthis(id){
    var js, fjs = document.getElementsByTagName('script')[0];
    if (document.getElementById(id)) return;
    js     = document.createElement('script'); 
    js.id  = id;
    js.src = '//s7.addthis.com/js/300/addthis_widget.js#pub=AddThis';
    fjs.parentNode.insertBefore(js, fjs);
}
function LOAD_isfb(d, s, id, appid, lang ){
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    if(appid == ''){
        js.src = 'https://connect.facebook.net/'+lang+'/sdk.js#xfbml=1&version=v2.12';
    }
    else {
        js.src =   "//connect.facebook.net/"+lang+"/all.js#xfbml=1&appId="+appid;
    }
    fjs.parentNode.insertBefore(js, fjs);
}
function CHECK_divtop(cls){
    var scrollTop     = $(window).scrollTop();
    var elementOffset = $(cls).offset().top;
    var distance      = (elementOffset - scrollTop); 
    return distance;
}

$("#back-top").hide();
$(function(){
    if($(".iframe_load").length > 0) {
        $(".iframe_load").each(function(){
            $(this).attr('src',$(this).attr('iframe-src'));
        });
    };
    
    $(window).scroll(function () {
      if ($(this).scrollTop() > 100) {
        $('#back-top').fadeIn();
      } else {
        $('#back-top').fadeOut();
      }
    });
    $('#back-top a').click(function () {
      $('body,html').animate({
        scrollTop: 0
      }, 800);
      return false;
    });
    $('.goto_atop').click(function () {
      $('body,html').animate({
        scrollTop: 0
      }, 800);
      return false;
    });
});

function SEARCH_timkiem(url, cls) {
    if ($(cls).val() == '') {
        $(cls).focus();
        if($(".timkiem_top").hasClass("actiii")){
            $(".timkiem_top").removeClass("actiii")
        }
        else {
            $(".timkiem_top").addClass("actiii");
        }
    }
    else
        window.location.href = url + $(cls).val().trim().replace(/ /g, "+");
}
$('.input_search_enter').keypress(function (event) {
    var keycode = (event.keyCode ? event.keyCode : event.which);
    if (keycode == '13') {
        var cls = $(this).attr('data');
        var href = $(this).attr('data-href');
        SEARCH_timkiem(href, cls);
    }
});
var is_key_check = '';
function DONG_popup() {
    $(".dv-popup-cont").hide();
    $(".dv-popup-cont-child").hide();
}


function GOTO_sport(cls) {
    var target = $(cls);
    if (target.length) {
        $('html, body').animate({
            scrollTop: target.offset().top
        }, 700);
    }
}

$("body").click(function () {
    $(".dv-timkiem").removeClass("dv-timkiem-active");
});
$(".body-nohide").click(function (event) {
    event.stopPropagation();
});

function PLAY_video(id, name) {
    $(".js_name_video").html(name);
    $(".video_view_top iframe").attr("src", "https://www.youtube.com/./embed/" + id + "?rel=0&autoplay=1&gesture=media&mute=1");
    setTimeout(function () {
        GOTO_sport(".id_hide_video");
    }, 200);
};
$(".menu-active a").each(function () {
    var href = $(this).attr("href");
    href = href.replace(fullpath, "");
    href = href.replace(/\//g, "");
    href = href.toLowerCase();
    var url = window.location.href;
    url = url.replace(fullpath, "");
    url = url.replace(/\//g, "");
    url = url.toLowerCase();
    if (href == url) {
        $(this).parents('.menu-active > li').eq(0).addClass("active");
        return;
    }
});

var popup_active = 0;
function LOAD_popup_new(url, wid ){
    $(".dv-popup-new-child").removeAttr("style");
    if(wid != '') $(".dv-popup-new-child").width(wid);
    $("body").append('<div class="dv-loadding-pop"><img src="images/loadernew.gif" alt=""></div>');
    $( ".dv-nd-popup" ).load(url, function() {
        $(".dv-loadding-pop").remove();
        $("body").addClass("body_hide");
        resize_popup_new();
    });
}
function resize_popup_new(){
    popup_active = 1;
    $(".dv-popup-new").addClass("acti");
    if(($(".dv-popup-new-child").height()+20) > $(window).height()){
      $(".dv-popup-new-child").addClass("actiok");
    }
    else {
      $(".dv-popup-new-child").removeClass("actiok");
    }
}
$(function(){
    if(popup_active == 1){
        resize_popup_new();
    }
})
$( window ).resize(function() {
    if(popup_active == 1){
        resize_popup_new();
    }
});

$(".popup-close").click(function(){
    close_ispopup();
});
$(".dv-nd-popup").click(function(event){
    event.stopPropagation();
});
function close_ispopup(){
    $(".dv-nd-popup").html("");
    popup_active = 0;
    $("body").removeClass("body_hide");
    $(".dv-popup-new").removeClass("acti");
}
function LOAD_height(cls){
    var maxHeight = 0;
    $(cls).each(function(){
      if ($(this).height() > maxHeight) { maxHeight = $(this).height(); }
    });
    if(maxHeight != 0) $(cls).height(maxHeight);
}

function add_num_sp(id, loai) {
    var num = $(id).val();
    if(!isNaN(num)) {
        if(loai == "-1") {
            if(num > 0) num--;
        }
        else {
            num++;
        }
        $(id).val(num);
    }
}
function setCookie(name,value,days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}

function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

function popupwindow(url, title, w, h) {
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
}

$(document).ready(function() {
    var owl_run = $(".owl-auto");
    if($(".owl-auto").length > 0){
        owl_run = $(".owl-auto");
    }
    if($(".owl-auto-sp").length > 0){
        owl_run = $(".owl-auto-sp");
    }

    owl_run.each(function(){
      var is_slidespeed = $(this).attr("is_slidespeed");
      var is_navigation = $(this).attr("is_navigation") == 1 ? true : false;
      var is_dots       = $(this).attr("is_dots") == 1 ? true : false;
      var is_autoplay   = $(this).attr("is_autoplay") == 1 ? true : false;
      var is_items_0    = $(this).attr("data0");
      var is_items_1    = $(this).attr("data1");
      var is_items_2    = $(this).attr("data2");
      var is_items_3    = $(this).attr("data3");
      var is_items_4    = $(this).attr("data4");
      var is_items_5    = $(this).attr("data5");
      var is_lop        = $(this).attr("is_lop");
      if(is_lop == 1) is_lop = false; else is_lop = true;

      $(this).owlCarousel({
        loop:is_lop,
        lazyLoad: true,
        autoplayHoverPause: true,
        responsiveClass: true,
        nav : is_navigation,
        responsive : {
            0 : { items : is_items_0 },
            319 : { items : is_items_1 },
            479 : { items : is_items_2 },
            767 : { items : is_items_3 },
            991 : { items : is_items_4 },
            1199 : { items : is_items_5 }
        },
        dots: is_dots,
        autoplay: is_autoplay,
        autoplayTimeout: is_slidespeed == 1000 ? 5000 : is_slidespeed,
        autoplayHoverPause:true,
        navigationText : ["‹","›"]
      });
    });
});

function AJAX_post(u, d, r) {
    $.ajax({
        type: "POST",
        url: u,
        data: d,
        cache: !1,
        success: function (response) {
            r(response)
        }
    });
}

$(".showText a").click(function(){
    var f_char = $(this).attr("href");
        f_char = f_char.substr(0, 1);
        if(f_char == "#"){
            GOTO_sport($(this).attr("href"));
            return false;
        }
    return true;
});

function close_video_tb(){
  $(".dv-idvideo-youtube iframe").attr("src","");
  $(".dv-idvideo-youtube").hide();
  $(".dv-idvideo-youtube-cont").removeClass('actii');
  $(".dv-idvideo-youtube iframe").attr("src","");
}
function LOAD_video_youtube(id) {
  if(id == "") {
    $(".dv-idvideo-youtube").hide();
    $(".dv-idvideo-youtube-cont").removeClass('actii');
  }
  else {
    $(".dv-idvideo-youtube iframe").attr("src","https://www.youtube.com/embed/"+id+"?autoplay=1&amp;enablejsapi=1&amp;rel=0&amp;ytp-pause-overlay=0&amp;v="+id);
    $(".dv-idvideo-youtube").show();
    $(".dv-idvideo-youtube-cont").addClass('actii');
  }
};

function SetCurrency(myvalue) {
    myvalue = parseInt(myvalue);
    myvalue = addCommas(myvalue);
    return myvalue;
}

function addCommas(nStr) {
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + '.' + '$2');
    }
    return x1 + x2;
}
function close_ispopup_new(){
    $(".dv-popup-content-bg").removeClass("acti");
    $(".dv-popup-content").removeClass("acti");
}
