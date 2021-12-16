<%@include file="./Page/service/variable.jsp" %>
<%--只负责请求转发至登录页面--%>
<%--<jsp:forward page="Page/login.jsp?action=page"></jsp:forward>--%>
<%--<%--%>
<%--    response.sendRedirect("/javaEE_01/Page/login.jsp");--%>
<%--%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>

<body style="background: url(static/imgs/bgc1.jpg) no-repeat fixed;background-size: 100% 100%;">

    <button name="login" onclick="window.location='Page/login.jsp'"
            style="width: 150px ;height: 40px ;
            color:white;
            position:absolute;right: 10%;top: 10%;
            cursor: pointer;border-radius: 10px;
            border: none;background-color:rgb(123,170,253);">登录</button>
    <button name="register" onclick="window.location='Page/register.jsp'"
            style="width: 150px ;height: 40px ;
            color: white;
            position:absolute;right: 10%;top: 20%;
            cursor: pointer;border-radius: 10px;
            border: none;background-color:rgb(123,170,253);">注册</button>


</body>
</html>
