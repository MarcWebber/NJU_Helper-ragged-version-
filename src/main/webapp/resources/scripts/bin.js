"use strict"
var window_width = $(window).width();//获取屏幕高度
var window_height = $(window).height();
var new_alert = function () {
    window.alert = alert;

    function alert(data) {
        var a = document.createElement("div"),
            p = document.createElement("p"),
            btn = document.createElement("div"),
            textNode = document.createTextNode(data ? data : ""),
            btnText = document.createTextNode("确定");
        // 控制样式
        css(a, {
            "position": "fixed",
            "left": "0",
            "right": "0",
            "top": "15%",
            "width": "100px",
            "margin": "0 auto",
            "background-color": "#0093E9",
            "background-image": "linear-gradient(160deg, #0093E9 0%, #80D0C7 100%)",

            "font-size": "20px",
            // "font-family":"Arial" "楷体";
            "text-align": "center"
        });
        css(btn, {
            // "top":"20px";
            "background": "red",
        })
        // 内部结构套入
        p.appendChild(textNode);
        btn.appendChild(btnText);
        a.appendChild(p);
        a.appendChild(btn);
        // 整体显示到页面内
        document.getElementsByTagName("body")[0].appendChild(a);

        // 确定绑定点击事件删除标签
        btn.onclick = function () {
            a.parentNode.removeChild(a);
        }
    }

    function css(targetObj, cssObj) {
        var str = targetObj.getAttribute("style") ? targetObj.getAttribute("style") : "";
        for (var i in cssObj) {
            str += i + ":" + cssObj[i] + ";";
        }
        targetObj.style.cssText = str;
    }
}



/*
 * @BUG!!!!
 *
 */

var navigatorSetUp = function (x) {
    let header_navigators = $(x);
    for (let i = 0; i < 4; i++) {
        let nav = $(header_navigators[i]);
        $(nav).offset({left: (i * 0.25 + 0.125) * window_width - nav.width() / 2});
    }
}
navigatorSetUp(".header-navi div");
navigatorSetUp(".footer-navi div");

