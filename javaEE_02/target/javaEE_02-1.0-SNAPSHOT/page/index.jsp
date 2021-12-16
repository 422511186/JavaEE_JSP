<%@ page import="com.example.javaEE_02.pojo.User" %>
<%@ page import="com.example.javaEE_02.pojo.Commodity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.javaEE_02.pojo.Carts" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
    <script src="${pageContext.request.contextPath}/static/js/index.js"></script>
</head>

<body>
<%--引入两个JavaBean对象--%>
<jsp:useBean id="CommodityService" class="com.example.javaEE_02.api.service.Impl.CommodityServiceImpl" scope="application"/>
<jsp:useBean id="CartServiceImpl" class="com.example.javaEE_02.api.service.Impl.CartServiceImpl" scope="application"/>

<%--获取商品列表--%>
<%List<Commodity> commodities = CommodityService.getCommodities();%>
<% List<Carts> cartList = CartServiceImpl.getCartList(request, response); %>


<div class="index">
    <header class="header">
        <h1 class="app_name" id="header_title">首页</h1>
        <div class="header_box">
            <span>
                <input type="search" class="search" placeholder="搜索">
            </span>
            <span id="Cart">购物车</span>

            <% User user = (User) session.getAttribute("User");
                if (user != null) {%>
            <%=" <span id=\"user\"> 用户名:"%>
            <%= user.getUser_account()%>
            <%="</span>"%>
            <%=" <span id=\"Exit\">退出登录</span>"%>

            <%} else {%>
            <span id="login">登录</span>
            <span id="register">注册</span>
            <%}%>
        </div>
    </header>

    <main class="main" id="shopping_items">
        <% for (int i = 0; i < commodities.size(); i++) {%>
        <div class="item">
            <img src=<%=commodities.get(i).getDetail_img().get(0).getImg_info()%>>
            <span><%=commodities.get(i).getDetail()%></span>
            <div class="detail">
                <span class="price">￥<%=commodities.get(i).getPrice().toString()%></span>
                <span class="stock">库存 <span CLASS="stock_num"><%=commodities.get(i).getCount()%></span> </span>
            </div>
        </div>
        <% }%>
    </main>

    <main class="main " id="Cart_items" style=" display: none">
        <div class="all_price" style="margin-left: 100px">
            <div>总金额:<%=CartServiceImpl.getCartPrice(request, response)%></div>
        </div>

        <% for (int i = 0; i < cartList.size(); i++) {%>
        <div class="Cart_item">
            <input type="checkbox" name="layout" id=<%=cartList.get(i).getCommodity().getId()%>>
            <label for=<%=cartList.get(i).getCommodity().getId()%>></label>
            <img src=<%=cartList.get(i).getCommodity().getDetail_img().get(0).getImg_info()%> alt="">
            <div class="Cart_detail">
                <span class="_detail"><%=cartList.get(i).getCommodity().getDetail()%></span>
                <span class="nums">
<%--                        <span class="price" style="font-size: larger;" >￥<%=commodities.get(i).getPrice().toString()%></span>--%>
                        <a class="nums_front" onclick="" id=<%="nums_front_"+cartList.get(i).getCommodity().getId()%>></a>
                            <span class="_nums" id=<%="_nums_"+cartList.get(i).getCommodity().getId()%>> <%=cartList.get(i).getCount()%> </span>
                        <a class="nums_after" id=<%="nums_after_" + cartList.get(i).getCommodity().getId()%>></a>
                    </span>
            </div>
        </div>
        <% }%>

    </main>
</div>
</body>
<script>

</script>
</html>
