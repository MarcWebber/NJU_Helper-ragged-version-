<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <title>用户登录</title>
    <link rel="stylesheet" href="resources/css/login.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <style>
        #pic {
            border: black solid 2px;
            background-size: cover;
            height: 100px;
            width: 100px;
            background-image: url("resources/images/某猪的头像.jpg");
            border-radius: 51px;
        }
    </style>
    <script src="resources/scripts/sha256.js" type="text/javascript"></script>
</head>

<body>

<div id='stars2'></div>
<div id='stars3'></div>

<div class="login">

    <h2>用户登录</h2>
    <span class="login_box" id="pic"></span>
    <!--    以post方式提交表单，提交到login    -->
    <form id="loginform" method="post" action="${pageContext.request.contextPath}/login" onsubmit="return encrypt();">
        <div class="login_box">
            <input type="text" name='name' id='name' value="21125"
                   placeholder="请输入用户名"/>
            <label for="name"></label>
        </div>

        <div class="login_box">
            <input type="password" name='pwd' id='pwd'
                   placeholder="请输入密码" required/>
            <label for="pwd"></label>
        </div>

        <input id="log" type="submit" value="登录">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
    </form>
</div>
<script>
    <!--    登录验证    -->

</script>
<script>
    $(function (){
        console.log("你的初始用户名和密码都是你的学号，暂时还不支持更改密码，以后会改进");
    })
    'use strict'
    var login_box = document.getElementsByClassName("login");
    var url=getPath();
    if (window.innerWidth > 400) {
        login_box[0].clientWidth = 320;
    }

    function encrypt() {
        let pwd = document.getElementById('pwd').value;
        // pwd = document.getElementById('pwd').value = rstr_sha256(pwd);
        // $("#loginform").submit();
        return true;
    }
    function getPath(){
        let pathName = document.location.pathname;
        let index = pathName.substr(1).indexOf("/");
        let result = pathName.substr(0,login+1);
        alert(result);
        return result;
    }
</script>
</body>
</html>
