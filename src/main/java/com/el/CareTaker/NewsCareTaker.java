package com.el.CareTaker;

import com.el.News.NewsController;
import com.el.User.UserController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/4
 * @ Description:
 * Life is short, I use Java
 */
public class NewsCareTaker {
    public static Map<String, NewsController> newsControllerMap;
    // to administrate all the news needed to reduce extra work and improve performance
    // the return value has no meaning
    static {
        // to initialize
        newsControllerMap=new HashMap<>();
    }

    public static boolean appendDept(String deptName){
        if (newsControllerMap.containsKey("deptName")){
            return false;
        }else {
            newsControllerMap.put(deptName,new NewsController(deptName));
        }
        return true;
    }
    public static NewsController getNews(String dept){
        return newsControllerMap.get(dept);
    }
}
