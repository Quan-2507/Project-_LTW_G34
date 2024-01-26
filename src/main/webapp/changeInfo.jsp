<%@ page import="entity.Users" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26/01/2024
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();
%>
<jsp:include page="header.jsp"></jsp:include>
<div class="changeInF">
    <%
        Object object = session.getAttribute("account");
        Users account = null;
        if(object != null)
            account = (Users) object;
        if(account == null){
    %> <p  style="text-align: center; margin-top: 15px"><a href="login-signUp.jsp" >Bạn chưa đăng nhập</a></p>
    <%}else{%>
    <%
        String name = account.getName();
        Integer phoneNumber = account.getPhoneNumber();
        String email = account.getEmail();
        Date dateOfBirth = account.getDateOfBirth();
        String address = account.getAddress();
        String res = (String) request.getAttribute("res");
        res =(res == null)?"":res;
    %>
    <form id="changeNam" onsubmit="return check()" action="changeInfo" method="post">
        <table>
            <thead>
            <tr>
                <td colspan ="4">
                    <h5 class = "pt-3 pb-1"> THAY ĐỔI THÔNG TIN </h5>
                    <p class="text-center w-100 mb-0 <%=(res.equals("Cập nhật thành công!"))?"text-success":"text-danger"%>" id="res"><%=res%></p>
                </td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td colspan="2">
                    <%
                        if (account.getVerifyAccount().isStateVerify()) {%>
                    <label class="w-100">Tài khoản đã xác thực <i class="fa fa-check-circle text-success" aria-hidden="true"></i></label>
                    <%} else {%>
                    <label class="w-100 ">Tài khoản của bạn chưa xác thực, <a href="<%=url%>/reVerifyCode">xác thực ngay</a></label>
                    <%}%>
                </td>
            </tr>
            <tr id="changeName">
                <td >
                    <label>Họ và tên <span class="text-danger">*</span></label>
                </td>
                <td class="w-50">
                    <div id="InName">
                        <input id="HienThiTen" name="TenHT" type="text" value="<%= name%>">
                    </div>
                </td>
            </tr>
            <tr id="changeSDT">
                <td>
                    <label> Số điện thoại <span class="text-danger">*</span></label>
                </td>
                <td>
                    <div id="InSDT">
                        <input id="HienThiSDT" name="SDTHT" type="text" value="<%=phoneNumber%>">
                    </div>
                </td>
            </tr>
            <tr id="changegGmail">
                <td>
                    <label>Email<span class="text-danger">*</span></label>
                </td>
                <td>
                    <div id="InGmail">
                        <input id="HienThiGmail" name="GmailHT" type="text" value="<%=email%>">
                    </div>
                </td>
            </tr>
            <tr id="changeNgaySinh">
                <td>
                    <label>Ngày sinh<span class="text-danger">*</span></label>
                </td>
                <td>
                    <div id="InNS">
                        <input id="HienThiNS" name="HienThiNS" type="date" value="<%=dateOfBirth%>">
                    </div>
                </td>
            </tr>
            <tr id="changeDC">
                <td>
                    <label> Địa chỉ<span class="text-danger">*</span></label>
                </td>
                <td>
                    <div id="InDiaChi">
                        <input id="HienThiDC" name="DCHT" type="text" value="<%=address%>">
                    </div>
                </td>
            </tr>
            <tr id="SubmitSB">
                <td colspan="2">
                    <div><button id="submit" name="SB" onclick="my_function()" style="color: white"> LƯU </button></div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <%}%>
</div>
<script>
    $(document).ready(function () {
        var res = $('#res');
        if (res.text() === "Cập nhật thành công!") {
            res.addClass("text-success");
        } else {
            res.addClass("text-danger");
        }
    });
    function check() {
        var flag = true;
        var tenElement = document.getElementById("HienThiTen");
        var gmailElement = document.getElementById("HienThiGmail");
        var sdtElement = document.getElementById("HienThiSDT");
        var dcElement = document.getElementById("HienThiDC");
        var nsElement = document.getElementById("HienThiNS");
        var error = document.getElementById("res");

        var gmailReg = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        var phoneReg = /^\d{10}/;
        if(tenElement.value == "") {
            error.innerHTML = "Vui lòng nhập họ và tên!";
            flag = false;
        }else if(gmailElement.value == "") {
            error.innerHTML = "Vui lòng nhập Email!";
            flag = false;
        }else if(!gmailElement.value.match(gmailReg)) {
            error.innerHTML = "Email không hợp lệ!";
            flag = false;
        }else if(sdtElement.value == "") {
            error.innerHTML = "Vui lòng nhập số điện thoại!";
            flag = false;
        }else if(!sdtElement.value.match(phoneReg)) {
            error.innerHTML = "Số điện thoại không hợp lệ!";
            flag = false;
        }
        else if(dcElement.value == "") {
            error.innerHTML = "Vui lòng nhập địa chỉ!";
            flag = false;
        }else if(nsElement.value == "") {
            error.innerHTML = "Vui lòng chọn ngày sinh!";
            flag = false;
        }
        console.log(sdtElement.value);
        return flag;
    }
</script>
<script>
    if($('#res').text() === "Cập nhật thành công!") {
        setTimeout(function () {
            window.location.href = 'homePage';
        }, 2000);
    }
</script>
</body>
<script src="js/script.js"></script>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
</html>
