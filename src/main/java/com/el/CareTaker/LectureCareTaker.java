package com.el.CareTaker;

import com.el.News.LectureController;
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
public class LectureCareTaker {
    public static Map<String, LectureController> lectureControllerMap;
    // to administrate all the news needed to reduce extra work and improve performance
    // the return value has no meaning
    static {
        // to initialize
        lectureControllerMap=new HashMap<>();
    }

    public static boolean appendDept(String deptName){
        if (lectureControllerMap.containsKey("deptName")){
            return false;
        }else {
            lectureControllerMap.put(deptName,new LectureController(deptName));
        }
        return true;
    }
    public static LectureController getLectures(String dept){
        return lectureControllerMap.get(dept);
    }
}
