<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        /*聊天记录的列表*/
        .list {
            width: 100%;
            min-height: 30rem;
            flex: 0.7;
            /*border: 1px  #03a9f4 solid;*/
            flex-direction: column;
            overflow: auto;
        }

        .list::-webkit-scrollbar {
            width: 3px;
        }

        .list::-webkit-scrollbar-track {
            background-color: red;
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
        }

        .list::-webkit-scrollbar-thumb {
            background-color: green;
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
        }

        /*聊天记录的列表*/
        .list_item {
            font-size: 1rem;
            letter-spacing: 3px;
            width: 90%;
            margin-top: 0.5rem;
            margin-left: 1rem;
            padding: 0.7rem;
            word-wrap: break-word;
            word-break: break-all;

            display: flex;
        }

        .username {
            border: 1px #03a9f4 solid;
            flex: 0.1;
            padding: 12px;
            text-align: center;
        }

        .chat {
            border: 1px #03a9f4 solid;
            flex: 0.9;
            padding: 12px;
        }
        .startBtn{
            position: relative;
            right: -95%;
            bottom: 8%;
        }
    </style>
</head>
<%--<script src="https://cdn.jsdelivr.net/npm/vue"></script>--%>
<%--<script src="https://unpkg.com/axios/dist/axios.min.js"></script>--%>
<script type="text/javascript" src="static/js/vue.js" ></script>
<script type="text/javascript" src="static/js/axios.js"></script>
<body>
<div class="list" id="app">
    <div class="list_item" id="list_item" v-for="item in items" :key=items.msg>
        <div class="username">
            {{ item.username }}
        </div>
        <div class="chat">
            {{ item.msg }}
        </div>
    </div>
    <button class="startBtn" v-on:click="A"><img src="https://id.scuec.edu.cn/authserver/cusTheme/static/web/images/pass1.png" alt=""></button>
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            items: "",
            timeout: false
        },

        methods: {
            //获取消息列表
            GetList() {
                axios({
                    method: 'get',
                    url: '/javaEE_01/getChatList',
                }).then(res => {
                    this.items = res.data.list;
                })
            },

            //设置滚动条在最底部位置
            scroll() {
                document.getElementById("app").scrollTop = document.getElementById("app").scrollHeight;
            },
            Stopscroll() {
                console.log("Stopscroll");
                clearInterval(this.scroll);
            },
            timeGetList() {
                // if(this.timeout) return;
                this.GetList();
                setTimeout(this.timeGetList, 100); //time是指本身,延时递归调用自己,100为间隔调用时间,单位毫秒
            },
            timescroll() {
                if (this.timeout) return;
                this.scroll();
                setTimeout(this.timescroll, 100); //time是指本身,延时递归调用自己,100为间隔调用时间,单位毫秒
            },
            A() {
                this.timeout = !this.timeout;
                console.log(this.timeout);
                if (!this.timeout) {
                    this.timescroll();2
                    alert("启动...")
                }
            }
        },
        //钩子函数,页面创建时执行
        mounted() {
            //定时任务
            this.timeGetList();
            this.timescroll();
        }
    })

</script>
</html>
