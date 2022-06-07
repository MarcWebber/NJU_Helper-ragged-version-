// import https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js
var window_width = $(window).width();//获取屏幕高度
var window_height = $(window).height();
//设置一下输入框格式
let setInputBox = function () {
    let input = $(".search input");
    let len_width = $(input).height();
    let search_img = $(".search img");
    $(input).width($(window).width() / 2);
    search_img.height(len_width).width(len_width);
    let search_img_offset = $(search_img).offset();
    search_img.offset({
        top: search_img_offset.top - $(input).height() / 2,
        left: search_img_offset.left + $(input).width() / 2.8
    })
}
//增添一个放大镜点击效果
$('.search img').on('click', function () {
    alert("这个功能暂时还没有");
})
let setHeaderImg = function (img_block, img_name, num) {
    let len_width = $(".search input").height();
    img_name.height(len_width * 2).width(len_width * 2);
    let img_offset = $(img_name).offset();
    img_name.offset({top: img_offset.top - len_width, left: img_offset.left - len_width * num})
}
/**
 * 这是个BUG
 */
// $(".plus img").on("click",function (){
//         $(".plus img").rotate(20);
// });
setInputBox();
setHeaderImg($(".plus"), $(".plus img"), 2);
setHeaderImg($(".header-image"), $(".header-image img"), -0.5)
//    调正放大镜大小