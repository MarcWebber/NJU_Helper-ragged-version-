<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,user-scalable=0,initial-scale=1.0,
          minimum-scale=1.0, maximum-scale=1.0">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="resources/scripts/bin.js"></script>
    <script src="./resources/scripts/lectureSQL.js"></script>
    <script>
        var window_width = $(window).width();//获取屏幕高度
        var window_height = $(window).height();
        // new_alert();
    </script>
    <link rel="stylesheet" href="resources/css/head_style.css">
    <link rel="stylesheet" href="resources/css/footer_style.css">
    <link rel="stylesheet" href="resources/css/banner_style.css">
    <link rel="stylesheet" href="resources/css/section_style.css">
    <link rel="stylesheet" href="resources/css/constant_present.css">

    <title>主页</title>

</head>
<body class="el-main-page">
<!--头部开始-->
<header>
    <div class="header-top">
        <div class="header-image">
            <img src="resources/images/news.png" alt="LOGO">
        </div>

        <div class="search">
            <input type="text" placeholder="搜索">
            <img src="resources/images/glass.png" alt="放大镜">
        </div>
        <div class="plus">
            <img src="resources/images/plus.png" alt="plus">
        </div>

    </div>

    <div class="header-navi">
        <div id="navi1">
            <a href="activity.jsp" class="header_href">
                <p class="navi_line1">
                    <img src="resources/images/activity.png" width="25vh" height="25vh" alt="导航图1">
                </p>
                <p class="navi_line2">
                    <span class="header-text">最新活动</span>
                </p>
            </a>
        </div>

        <div id="navi2">
            <a href="./lecture.jsp" class="header_href">
                <p class="navi_line1">
                    <img src="resources/images/lecture.png" width="25vh" height="25vh" alt="导航图2">
                </p>
                <p class="navi_line2">
                    <span class="header-text">讲座信息</span>
                </p>
            </a>
        </div>

        <div id="navi3">
            <a href="href.jsp" class="header_href">
                <p class="navi_line1">
                    <img src="resources/images/link.png" width=25vh height=25vh alt="导航图3">
                </p>
                <p class="navi_line2">
                    <span class="header-text">个人链接</span>
                </p>
            </a>
        </div>

        <div id="navi4">
            <a href="home.jsp" class="header_href">
                <p class="navi_line1">
                    <img src="resources/images/personal_info.png" width=25vh height=25vh alt="!">
                </p>
                <p class="navi_line2">
                    <span class="header-text">个人中心</span>
                </p>
            </a>
        </div>
    </div>

</header>
<!--头部结束-->

<div id="container">

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

<script type="text/javascript" src="resources/scripts/header_script.js"></script>

<script src="resources/scripts/section_script.js"></script>

<script src="./resources/scripts/render_content.js"></script>


<script>
    $(function (){
        $(document).ready(function (){
            $.post("${pageContext.request.contextPath}/LectureServlet",function (data){
                function CreateList(){
                    let length=data.length;
                    console.log(data);
                    // console.log(data.size);
                    for (let i = 0;  i < length; i++){
                        AppendHrefToContainer(i, "href_list", "title_list", "text_list", "date_list")
                    }
                }
                function ResetList(){
                    let news=JSON.parse(data);
                    let hrefs=$('.pure_link');
                    let titles=$('.new_title');
                    let texts=$('.new_text');
                    let times=$('.new_time');
                    for (let i = 0; i < 17; i++){
                        // console.log(news[i]);
                        let re=news[i];
                        // console.log(re);
                        // console.log(re.NEWS_ABSTRACT);
                        // console.log(re.NEWS_URL);
                        hrefs[i].setAttribute("href",re.LEC_URL);
                        titles[i].innerText=re.LEC_TITLE;
                        texts[i].innerText=re.LEC_ABSTRACT;
                        times[i].innerText=re.LEC_DATE;
                        // console.log(hrefs[i].text);
                        // console.log(texts[i].text);
                    }
                }
                // RecreateNewsTable()
                CreateList()
                ResetList()
                var _element = document.getElementById('container'),
                    OriginalPos = _element.offsetTop,  // 初始的值
                    Container_height = _element.offsetHeight + OriginalPos;
                var is_touching = false

                _element.addEventListener("touchstart", function(e){
                    let touch_pl = e.touches[0].pageY;
                    if (touch_pl > OriginalPos && touch_pl < OriginalPos + Container_height){
                        is_touching = true // 记录差值
                    }
                }, false);

                _element.addEventListener('touchmove', function(e) {
                    // e.touches[0].pageY 当前位置
                    let touch_pl = e.touches[0].pageY;
                    if (is_touching){
                        _element.style.setProperty("top", touch_pl) // 记录差值
                    }

                }, false);

                _element.addEventListener('touchend', function(e) {
                    _element.style.setProperty("top", OriginalPos)
                    RecreateNewsTable()
                    ResetList()

                    is_touching = false
                }, false);
            })
        })
    })
</script>

<script>
    $(function (){
        $.post("${pageContext.request.contextPath}/check",function (){
            alert("登陆超时！");
        })
    })
</script>

</html>
