<%@include file="variable.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="refresh" content="3;url=Page/login.jsp">

</head>
<body>
<h1>登陆失败，请检查用户名和密码是否正确！</h1>
<h3><p id="time">3秒后将自动跳转登录页面，请重新登录
    <p/></h3>
</body>
<script>
    var second = 3;
    var time = document.getElementById("time");

    function showTime() {
        second--;
        time.innerText = second + "秒后将自动跳转登录页面，请重新登录";
    }

    setInterval(showTime, 1000);
</script>
</html>
