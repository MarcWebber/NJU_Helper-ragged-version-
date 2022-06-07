<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,user-scalable=0,initial-scale=1.0,
          minimum-scale=1.0, maximum-scale=1.0">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="resources/scripts/bin.js"></script>
    <script>
        var window_width = $(window).width(); //获取屏幕高度
        var window_height = $(window).height();
        // new_alert();
    </script>
    <link rel="stylesheet" href="resources/css/head_style.css">
    <link rel="stylesheet" href="resources/css/footer_style.css">
    <link rel="stylesheet" href="resources/css/banner_style.css">
    <link rel="stylesheet" href="resources/css/section_style.css">
    <link rel="stylesheet" href="resources/css/homepg_style.css">
    <title>主页</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .infoline {
            /* border: 1px solid black; */
            position: relative;
            height: 15vh;
            width: 100vw;
            background-color: white;
        }

        .sminfoline {
            position: relative;
            height: 5vh;
            width: 100vw;
            background-color: white;
        }

        .pixmap {
            /* 头像框 */
            position: absolute;
            height: 15vh;
            width: 30vw;
            left: 0;
            top: 0;
        }

        .img {
            /* 图片居中显示 */
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            height: 75%;
            width: auto;
        }

        .name {
            /* 头像框右侧栏 */
            position: absolute;
            height: 10vh;
            width: 60vw;
            left: 30vw;
            top: 0;
            padding: 5vw;
        }

        .voidline {
            /* 空行 */
            position: relative;
            height: 2vh;
            width: 100vw;
        }

        .normalline {
            position: relative;
            height: 5vh;
            line-height: 5vh;
        }

        .smallpix {
            position: absolute;
            height: 5vh;
            width: 20vw;
            top: 0;
            left: 0;
        }

        .smallpix2 {
            position: absolute;
            height: 5vh;
            top: 0;
            left: 20vw;
        }

        .specialpix {
            position: absolute;
            height: 9vh;
            width: 9vh;
            z-index: 10;
            top: 3vh;
            right: 5vw;
        }
        #username{
            display: flex;
            transform: translateY(10%);
            font-family: "Arial","楷体";
            size: auto;
        }

        #userinfo{
            display: flex;
            transform: translateY(-4vh);
            font-family: "Arial","楷体";
            size: auto;
        }

    </style>

    <script>
        function nameClicked(){
            var name = prompt("请输入新用户名")
            if (name != null){
                $("#username").text(name);
            }
        }

        function infoClicked(){
            var name = prompt("请输入新签名")
            if (name != null){
                $("#userinfo").text(name);
            }
        }
    </script>
</head>

<body class="el-main-page" bgcolor="WhiteSmoke">
<!-- 个人信息栏 -->
<div class="infoline">
    <div class="pixmap">
        <img class="img" id="user_img" src="" alt="用户照片">
    </div>
    <div class="name">
        <b><span id="username" style="font-size: medium; " onclick="nameClicked()"></span></b>
        <br><br>
        <p><span id="userinfo" style="font-size: x-small; " onclick="infoClicked()"></span></p>
    </div>
</div>
<div class="voidline"></div>
<div class="infoline">
    <div class="normalline">
        <!-- the first line -->
        <div class="smallpix"><img class="img" src="./resources/images/heart.png" alt="志愿服务图标"></div>
        <div class="smallpix2"><p>志愿服务统计：</p></div>
    </div>
    <div class="normalline">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;您的志愿服务时长：</p>
    </div>
    <div class="normalline">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;所需志愿服务时长：</p>
    </div>
    <img class="specialpix" src="resources/images/hege.png" alt="合格">
</div>
<div class="voidline"></div>
<div class="infoline">
    <div class="normalline">
        <!-- the first line -->
        <div class="smallpix"><img class="img" src="./resources/images/heart.png" alt="劳育服务图标"></div>
        <div class="smallpix2">
            <p>劳育时长统计：</p>
        </div>
    </div>
    <div class="normalline">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;您的劳育时长：</p>
    </div>
    <div class="normalline">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;所需劳育时长：</p>
    </div>
    <img class="specialpix" src="resources/images/hege.png" alt="合格">

</div>
<div class="voidline"></div>
<div class="sminfoline">
    <div class="normalline">
        <div class="smallpix">
            <img class="img" src="./resources/images/config.png" alt="设置图标">
        </div>
        <div class="smallpix2">
            <p>设置</p>
        </div>
    </div>
</div>
<!--底部栏-->
<footer>
    <div class="footer-navi">
        <div id="footer_navi1">
            <a href="main.jsp" class="footer_href">
                <p class="navi_line1">
                    <img src="./resources/images/activity.png" alt="导航图1" width=25vh height=25vh>
                </p>
                <p class="navi_line2">
                    <span class="header-text">主页</span>
                </p>
            </a>
        </div>


        <div id="footer_navi2">
            <a href="news.jsp" class="footer_href">
                <p class="navi_line1">
                    <img src="./resources/images/lecture.png" alt="导航图2" width=25vh height=25vh>
                </p>
                <p class="navi_line2">
                    <span class="header-text">新闻</span>
                </p>
            </a>
        </div>

        <div id="footer_navi3">
            <a href="href.jsp" class="footer_href">
                <p class="navi_line1">
                    <img src="./resources/images/link.png" alt="导航图3" width=25vh height=25vh>
                </p>
                <p class="navi_line2">
                    <span class="header-text">优站</span>
                </p>
            </a>
        </div>

        <div id="footer_navi4" class="footer_href">
            <a href="home.jsp" class="footer_href">
                <p class="navi_line1">
                    <img src="./resources/images/personal_info.png" alt="导航图4" width=25vh height=25vh>
                </p>
                <p class="navi_line2">
                    <span class="header-text">我的</span>
                </p>
            </a>
        </div>
    </div>
</footer>
</body>

</html>

</html>
<script>
    $(function () {
        $.get("${pageContext.request.contextPath}/UserServlet", function (data) {
                // console.log(data);
                let result = JSON.parse(data);
                console.log(result);
                $("#username").text(result.name);
                $('#userinfo').text(result.signature);
                <%--alert("${pageContext.request.contextPath}");--%>
                document.getElementById('user_img').src=(result.profile);
                console.log(document.getElementById('user_img').src);
            }
        )
    })
</script>
