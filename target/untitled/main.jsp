<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,user-scalable=0,initial-scale=1.0,
          minimum-scale=1.0, maximum-scale=1.0">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="resources/scripts/bin.js"></script>
    <!-- local SQL here -->
    <script src="resources/scripts/newsSQL.js"></script>
    <script src="./resources/scripts/ActivitiesSQL.js"></script>
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
            <a href="lecture.jsp" class="header_href">
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

<!--轮播图开始-->
<div class="banner">
    <div id="img_container">
        <span class="on"></span>
        <span></span>
        <span></span>
    </div>
    <ul id="btn_list">
        <li class="btn_active">1</li>
        <li>2</li>
        <li>3</li>
        <li>4</li>
        <li>5</li>
    </ul>
    <ul></ul>
</div>

<section>
    <div class="section_wrapper" id="activities">
        <div class="section_top">
            <div class="section_ui">ui
            </div>
            <div class="section_text" onclick="window.location.href='activity.jsp'; ">活动速览
            </div>
            <div class="section_extra">最新活动早知道
            </div>
        </div>
        <div class="section_main">
            <div class="section_left" id="section_activity_left">
                <a class="tag" id = "activities_left_href">
                    <div class="tag_title" id="activities_left_title">
                    </div>
                    <div class="tag_text" id="activities_left_text">
                    </div>
                    <div class="tag_time" id="activities_left_date">
                    </div>
                </a>
            </div>
            <div class="section_right" id="section_activity_right">
                <a class="tag" id = "activities_right_href">
                    <div class="tag_title" id="activities_right_title">
                    </div>
                    <div class="tag_text" id="activities_right_text">
                    </div>
                    <div class="tag_time" id="activities_right_date">
                    </div>
                </a>
            </div>
        </div>

    </div>
    <div class="section_wrapper" id="lectures">
        <div class="section_top">
            <div class="section_ui">ui
<!--                <img src="resources/images/讲座.png" alt="123">-->
            </div>
            <div class="section_text" onclick="window.location.href='lecture.jsp'; ">讲座信息
            </div>
            <div class="section_extra">哪些大牛在开讲
            </div>
        </div>
        <div class="section_main">
            <div class ="section_left" id="section_lecture_left">
                <a class="tag" id = "lecture_left_href">
                    <div class="tag_title" id="lecture_left_title">
                    </div>
                    <div class="tag_text" id="lecture_left_text">
                    </div>
                    <div class="tag_time" id="lecture_left_date">
                    </div>
                </a>
            </div>
            <div class="section_right" id="section_lecture_right">
                <a class="tag" id = "lecture_right_href">
                    <div class="tag_title" id="lecture_right_title">
                    </div>
                    <div class="tag_text" id="lecture_right_text">
                    </div>
                    <div class="tag_time" id="lecture_right_date">
                    </div>
                </a>
            </div>
        </div>

    </div>

    <div class="section_wrapper" id="lectures">
        <div class="section_top">
            <div class="section_ui">ui
<!--                <img src="resources/images/讲座.png" alt="123">-->
            </div>
            <div class="section_text" onclick="window.location.href='news.html'; ">院系新闻
            </div>
            <div class="section_extra">院系事务知多少
            </div>
        </div>
        <div class="section_main">
            <div class="section_left" id="section_news_left">
                    <a class="tag" id = "news_left_href">
                        <div class="tag_title" id="news_left_title">
                        </div>
                        <div class="tag_text" id="news_left_text">
                        </div>
                        <div class="tag_time" id="news_left_date">
                        </div>
                    </a>
            </div>
            <div class="section_right" id="section_news_right">
                <a class="tag" id = "news_right_href">
                    <div class="tag_title" id="news_right_title">
                    </div>
                    <div class="tag_text" id="news_right_text">
                    </div>
                    <div class="tag_time" id="news_right_date">
                    </div>
                </a>
            </div>
        </div>

    </div>
</section>
<!--轮播图结束-->
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

<script>//轮播图js
let current_index = 0;//当前显示的图片
let target_index = 0;
let img_list = $("#img_container span");
let timer = null;
let load_img = function () {
    //通过ajax获取图片信息后将图片标签加入到img_list,,
    // let images=... 请求图片资源，获取其url,以数组的形式存储
    // let img_location=... 请求图片源地址，获取其location,以数组的形式存储
    img_list[0].style.cssText = "background: url(resources/images/nju.jfif);background-size:cover;width:100%;height:100%";
    img_list[1].style.cssText = "background: url(resources/images/nju.jpg);background-size:cover;width:100%;height:100%";
    img_list[2].style.cssText = "background: url(resources/images/nju3.png);background-size:cover;width:100%;height:100%";

    // img_list[1].src = 'sources/images/热火.jfif';
    // img_list[0].width=window_width;
    // img_list[0].height=window_height;
    // img_list[0].height = img_list.height();

    // for (let x of img_list) {
    //     //对每一张图片进行点击事件绑定
    //     x.onclick(function () {
    //         window.open('http://121.37.89.204')
    //     })
    //     // x.addC
    //     // x.cssText({
    //     //     "width":"80vw",
    //     //     "height":"20vh",
    //     //     "border-radius":"20px"
    //     // })
    // }
}

load_img();

//轮播函数
function slide() {
    target_index = current_index + 1;
    current_index = target_index % img_list.length; // 获取当前index
    for (let x of img_list) {
        x.className = " ";
    } // 设置其他图片隐藏
    img_list[current_index].className = "on"; // 设置当前index图片显示
    // btnList.forEach(v => v.className = "unitBtn") // 设置其他按钮为灰色
    // btnList[curIndex] .className = "unitBtn btnActive"; // 设置当前按钮为蓝色
}

timer = setInterval(() => {
    slide()
}, 2000); // 设置定时器定时切换
// })();


// alert("还说呢杨")
</script>
<script src="resources/scripts/section_script.js"></script>

<script>

    function SetLectureHurdle(title_name, href_name, time_name, index){
            SetTitleFromLecturesSQL(title_name, index)
            SetHrefFromLecturesSQL(href_name, index)
            SetDateFromLecturesSQL(time_name, index)
        } 
    function SetNewsHurdle(title_name, href_name, time_name, index){
            SetTitleFromNewsSQL(title_name, index)
            SetHrefFromNewsSQL(href_name, index)
            SetDateFromNewsSQL(time_name, index)
    }

    function SetActivitiesHurdle(title_name, href_name, time_name, index){
            SetTitleFromActivitiesSQL(title_name, index)
            SetHrefFromActivitiesSQL(href_name, index)
            SetDateFromActivitiesSQL(time_name, index)
    }

    RecreateNewsTable()
    RecreateActivitiesTable()
    RecreateLecturesTable()
    SetLectureHurdle("lecture_left_title", "lecture_left_href", "lecture_left_date", 0)
    SetLectureHurdle("lecture_right_title", "lecture_right_href", "lecture_right_date", 1)
    SetNewsHurdle("news_left_title", "news_left_href", "news_left_date", 0)
    SetNewsHurdle("news_right_title", "news_right_href", "news_right_date", 1)
    SetActivitiesHurdle("activities_left_title", "activities_left_href", "activities_left_date", 0)
    SetActivitiesHurdle("activities_right_title", "activities_right_href", "activities_right_date", 1)

</script>


</html>