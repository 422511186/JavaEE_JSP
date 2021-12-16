<%@ page import="com.example.javaEE_02.api.service.Impl.UserServiceImpl" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login_register.css">
    <script src="${pageContext.request.contextPath}/static/js/login.js"></script>
</head>
<body>

<%--如果已经登陆，直接跳转至聊天室页面--%>
<%
    Object user = session.getAttribute("User");
    if (user != null)
        response.sendRedirect("/javaEE_02/page/index.jsp");
%>


<%--定义并初始化变量--%>
<%!
    String username = "";
    String password = "";
    String yzmImg = "";
%>

<%--取cookie中的值--%>
<%
    //重置输入框
    username = "";
    password = "";
    yzmImg = "";

    //获取验证码图片的数据流
    yzmImg = UserServiceImpl.getImageCode(request);

    //遍历cookie实现账号密码自动填充功能
    Cookie[] cookies = request.getCookies();

    if (cookies != null && cookies.length >= 2) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                username = URLDecoder.decode(cookie.getValue(), "UTF-8");
            }
            if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }
        }
    }
%>


<div class="loginBox">
    <form method="post" action="${pageContext.request.contextPath}/login">
        <img alt="" class="img" id="login_img" src="${pageContext.request.contextPath}/static/imgs/img_1.png">
        <div>
            <%--            <input class="text" placeholder="账号" type="text" name="username" value="">--%>
            <input class="text" type="text" value=
            <%--判断填充信息--%>
                <%if (username.length()==0){ %>
                    ""
                <%}else {%>
                <%=username%>
                <%}%>
                   placeholder="账号" name="username">
        </div>
        <div>
            <%--            <input class="password" placeholder="密码" type="password" name="password" value="">--%>
            <input class="text" type="password" value=
            <%--判断填充信息--%>
                <%if (password.length()==0){ %>
                    ""
                <%}else {%>
                <%=password%>
                <%}%>
                   placeholder="密码" name="password">
        </div>
        <div class="yzmBox">
            <input class="yzmText" type="text" name="yzm" value="" placeholder="验证码">
            <img class="yzm" src=<%=yzmImg%> alt="">
        </div>
        <div class="pwd">
            <input type="checkbox" id="rememberPwd" name="rememberPwd" value="记住密码">
            <label for="rememberPwd" class="rmbPwd">记住密码</label>
        </div>
        <div>
            <input class="submit" type="submit" value="登录">
            <input class="submit" type="reset" value="重置">
        </div>
    </form>
</div>

</body>

</html>
