<%@ page import="com.example.javaEE_02.api.service.Impl.UserServiceImpl" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login_register.css">
    <script src="${pageContext.request.contextPath}/static/js/register.js"></script>
</head>
<body>
<div class="loginBox">
    <form method="post" action="${pageContext.request.contextPath}/register">
        <img alt="" class="img" id="register_img" src="${pageContext.request.contextPath}/static/imgs/img_1.png">
        <div>
            <input class="text" placeholder="账号" name="username" type="text" value="">
        </div>
        <div>
            <input class="password" placeholder="密码" type="password" name="password" value="">
        </div>
        <div class="yzmBox">
            <input class="yzmText" type="text" value="" name="yzm" placeholder="验证码">
            <img class="yzm" src=<%=UserServiceImpl.getImageCode(request)%> alt="">
        </div>

        <div>
            <input class="submit" type="submit" value="注册">
            <input class="submit" type="reset" value="重置">
        </div>
    </form>
</div>

</body>
</html>
