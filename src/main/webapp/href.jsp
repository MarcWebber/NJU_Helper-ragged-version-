<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <meta name="viewport"
    content="width=device-width,user-scalable=0,initial-scale=1.0,
    minimum-scale=1.0, maximum-scale=1.0"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>链接跳转</title>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="resources/scripts/bin.js"></script>

    <script>
        var window_width = $(window).width();//获取屏幕高度
        var window_height = $(window).height();
        // new_alert();
    </script>


    <script>
        function when_clicked(){
            var href_here = prompt("请输入您想要输入的链接")
            if (href_here != null){
                var plus_button = document.getElementById("plus_button")
                var container = document.getElementById("wrapper")
                var this_width = container.offsetWidth
                var left_val = plus_button.offsetLeft
                console.log(this_width)
                var top_val = plus_button.offsetTop
                var new_left_val
                var new_top_val
                new_left_val = left_val + 0.32 * this_width
                console.log(new_left_val)
                if (new_left_val > 0.8 * this_width){
                    new_left_val = 0
                    new_top_val = top_val + 0.32 * this_width
                }
                plus_button.style.setProperty('left', new_left_val +'px')
                plus_button.style.setProperty('top', new_top_val +'px')
                console.log(plus_button.offsetLeft)
                var href_board = document.createElement("a")
                var ele = document.createElement("img" );
                ele.setAttribute("src", "./resources/images/new_link.jfif")
                href_board.setAttribute("class", "href_two")
                ele.setAttribute("class", "img_suit")
                href_board.setAttribute("href", href_here)
                href_board.setAttribute("target", "_blank")
                href_board.style.setProperty("left", left_val + "px")
                href_board.style.setProperty("top", top_val + "px")
                href_board.appendChild(ele)
                container.appendChild(href_board)
            }
        }
    </script>

    <style>
        *{
            margin: 0;
            padding: 0;
        }

        #header{
            position: absolute;
            top: 0;
            height: 5vh;
            width: 100%;
            text-align: center;
            background-color: green;
            color:white;
            line-height: 5vh;
            size: 3vh;
        }

        #wrapper{
            position: absolute;
            top: 5vh;
            width: 100%;
            height: auto;
            bottom: 10vh;
        }

        /* #footer{
            position:absolute;
            bottom: 0%;
            height: 5%;
            width: 100%;
            background-color: yellowgreen;
        } */

        .href_one{
            text-decoration: none;
            display: inline-block;
            width: 32%;
            height: auto;
            color: black;
            text-align: center;
        }

        .href_two{
            text-decoration: none;
            display: inline-block;
            width: 32%;
            height: auto;
            position: absolute;
        }

        .over_one:hover{
            text-decoration: none;
            color: yellow;
        }

        .img_place{
            max-width: 100%;
            max-height: 100%;
        }

        .align_center{
            text-align: center;
        }

        .align_block_right{
            /* position: absolute; */
            right: 0%;
        }

        .align_block_centre{
            /* position: absolute; */
            left: 34%;
        }

        .text_white{
            color: white;
        }

        .text_selected{
            color: blue;
        }

        .img_suit{
            width: 100%;
            height: auto;
        }


    </style>
    <!-- <link rel="stylesheet" href="resources/css/head_style.css"> -->
    <link rel="stylesheet" href="resources/css/footer_style.css">
</head>
<body>
<div id="header">便捷链接</div>
<div id = "wrapper">
    <a href="https://www.nju.edu.cn/" class="href_one" target="_blank" id="href_1">
        <img src="./resources/images/href_logo/nju_logo.jpg" class="img_place">
        <!-- <p>南京大学官网</p> -->
    </a>
    <a href="https://ndwy.nju.edu.cn/" class="href_one" target = "_blank" id="href_2">
        <img src="./resources/images/href_logo/nju_logo.jpg" class="img_place">
        <!-- <p>南京大学五育管理系统</p> -->
    </a>
    <a href="https://jw.nju.edu.cn" class="href_one" target = "_blank" id="href_3">
        <img src="./resources/images/href_logo/nju_logo.jpg" class="img_place">
        <!-- <p>南京大学本科生院</p> -->
    </a>

    <img src="./resources/images/get_more_link.png", class="href_two" id="plus_button" onclick="when_clicked()">

    <!-- <a href="#" class="href_one" target = "_blank">
        空链接
    </a> -->
</div>
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

<script>
    var GetUpButton = document.getElementById('href_1')
    var top_plus = GetUpButton.offsetHeight
    var GetPlusButton = document.getElementById("plus_button")
    GetPlusButton.style.setProperty('left', 0 + 'px')
    GetPlusButton.style.setProperty('top', top_plus + 'px')
    // for (let i = 1; i <= 3; i++){
    //     let button_here = document.getElementById("href_" + i)
    //     button_here.style.setProperty('position', 'absolute')
    //     button_here.style.setProperty('top', 5 + 'vh')
    // }
</script>
</html>