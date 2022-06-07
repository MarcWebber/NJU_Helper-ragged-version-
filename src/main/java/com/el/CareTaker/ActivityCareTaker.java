package com.el.CareTaker;

import com.el.News.ActivityController;
import com.el.News.NewsController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/6
 * @ Description:
 * Life is short, I use Java
 */

public class ActivityCareTaker {
    public static Map<String, ActivityController> activityControllerMap;
    // to administrate all the news needed to reduce extra work and improve performance
    // the return value has no meaning
    static {
        // to initialize
        activityControllerMap=new HashMap<>();
    }

    public static boolean appendDept(String deptName){
        if (activityControllerMap.containsKey("deptName")){
            return false;
        }else {
            activityControllerMap.put(deptName,new ActivityController(deptName));
        }
        return true;
    }
    public static ActivityController getActivities(String dept){
        return activityControllerMap.get(dept);
    }
}
