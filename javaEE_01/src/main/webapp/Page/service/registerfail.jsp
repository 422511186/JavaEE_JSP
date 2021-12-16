<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="variable.jsp" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="refresh" content="3; url=Page/register.jsp">
</head>
<body>
<h1>注册失败，该用户名已被占用！</h1>
<h3>
    <p id="time">3秒后将自动跳转至注册页面<p/>
</h3>
</body>
<script>
    var second = 3;
    var time = document.getElementById("time");

    function showTime() {
        second--;
        time.innerText = second + "秒后将自动跳转至注册页面";
    }

    setInterval(showTime, 1000);
</script>
</html>
