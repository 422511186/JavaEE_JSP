<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="variable.jsp" %>
<html>
<head>
    <title>聊天室</title>
    <link rel="stylesheet" href="static/css/navigation.css">
    <link rel="stylesheet" href="static/css/chat.css">

</head>
<body>

<ul>
    <li><div id="webName">聊天室</div></li>
    <li style="float:right">
        <form action="exit">
            <div class="button_box">
                <button class="button" name="exit" value="on" >退出登录</button>
            </div>
        </form>
    </li>
</ul>

<div class="row">
    <div class="leftcolumn">
        <jsp:include page="RoomHeader.jsp"></jsp:include>
    </div>

    <div class="rightcolumn">
        <div class="_main">
            <div class="list_box">
                <jsp:include page="list.jsp"></jsp:include>
            </div>
            <%--        <iframe  class="list header" src=<%=path1%>></iframe>--%>
            <div class="reply_box">
                <textarea cols="30" class="reply_text" id="reply_text1"></textarea>

                <button class="btn_send" onclick=loadDoc()>
                    <span>发送</span>
                </button>

            </div>
        </div>
    </div>
</div>


<%--    <iframe class="header" src=<%=path%>></iframe >--%>



</body>
<script>
    function loadDoc() {
        var xhttp = new XMLHttpRequest();
        var msg = document.getElementById("reply_text1").value;
        var url = "/javaEE_01/ChatRoom?msg=" + msg;
        if (msg===""){
            alert("不能发送空消息!");
            return;
        }

        xhttp.open("POST", url, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                // alert("发送成功");
                document.getElementById("reply_text1").value = "";

            }
        };
    }
</script>
</html>
