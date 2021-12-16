<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="variable.jsp" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="refresh" content="3;url=Page/login.jsp">
</head>
<body>
<h1>注册成功！！！</h1>
<h3><p id="time">3秒后页面将自动跳转至登录界面
    <p/></h3>
</body>
<script>
    var second = 3;
    var time = document.getElementById("time");

    function showTime() {
        second--;
        time.innerText = second + "秒后页面将自动跳转至登录界面";
    }

    setInterval(showTime, 1000);
</script>
</html>
