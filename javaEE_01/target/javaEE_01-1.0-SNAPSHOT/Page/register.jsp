<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/11/10
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.javaEE.Service.Impl.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./service/variable.jsp" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="static/css/login.css">

</head>
<body>


<div id="box">
    <form action="Register" method="post">
        <img id="img01" src="https://id.scuec.edu.cn/dzlogo.png">
        <div id="txt01">账号登录</div>
        <div id="in">
            <div class="in02">
                <img class="img02" src="https://id.scuec.edu.cn/authserver/cusTheme/static/web/images/user1.png">
                <%--<input class="text" type="text" name="username" value="" placeholder="请输入学号/工号">--%>
                <input class="text" type="text" value=""
                       placeholder="账号" name="username">
            </div>
            <hr style="background-color: #d9d1d1; border: none; height: 1px"/>
            <div class="in02">
                <img class="img02" src="https://id.scuec.edu.cn/authserver/cusTheme/static/web/images/pass1.png">
                <%--<input class="text" type="password" name="password" value="" placeholder="请输入密码">--%>
                <input class="text" type="password" value=""
                       placeholder="密码" name="password">
            </div>
            <hr style="background-color: #d9d1d1; border: none; height: 1px"/>
            <div class="in02">
                <img class="img02" src="static/imgs/yzm.png">
                <input class="yzmtext01" type="text" value="" name="yzm" placeholder="验证码">
                <img class="yzm" src=<%=UserServiceImpl.getImageCode(request)%> alt="">
            </div>
        </div>

        <%--<div class="yzmBox">--%>
        <%--    <input class="yzmtext" type="text" value="" name="yzm">--%>
        <%--    &lt;%&ndash;            <img class="yzm" src="data:image/png;base64,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" alt="" >&ndash;%&gt;--%>
        <%--    <img class="yzm" src=<%=yzmImg%> alt="">--%>
        <%--</div>--%>
        <div id="dbtn">
            <input class="btn" type="submit" value="注册">
            <input class="btn" type="reset">
        </div>
    </form>
</div>

</body>
</html>
