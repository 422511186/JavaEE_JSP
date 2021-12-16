<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="variable.jsp" %>
<html>
<head>
    <title>Title</title>
    <%--    <meta http-equiv="refresh" content="2">--%>
</head>
<%--<script src="https://cdn.jsdelivr.net/npm/vue"></script>--%>
<%--<script src="https://unpkg.com/axios/dist/axios.min.js"></script>--%>

<script type="text/javascript" src="static/js/vue.js" ></script>
<script type="text/javascript" src="static/js/axios.js"></script>

<style>
</style>

<body>
<%--<%= ((Set)application.getAttribute("set")).size() %><%= (Set)application.getAttribute("set") %>--%>

<div style="padding: 30px" class="btm">

    在线人数:
    <p id="a"></p>

    在线用户: <p id="b"></p>
</div>

</body>
<script>
    function showq() {
        this.axios({
            method: 'get',
            url: '/javaEE_01/GetCount',
        }).then(res => {
            document.getElementById("a").innerText = res.data.size;
            document.getElementById("b").innerText = res.data.set;
        })
    }

    showq();
    setInterval(showq, 1000);
</script>
</html>
