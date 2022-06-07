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
public class UserCareTaker {
    public static Map<Integer, UserController> userControllerMap;

    static {
        userControllerMap=new HashMap<>();
    }

    public static boolean appendUser(Integer Id){
        if (userControllerMap.containsKey(Id)){
            return false;
        }else {
           userControllerMap.put(Id,new UserController(Id));
           System.out.println("user "+Id+" is created!");
        }
        return true;
    }
    public static UserController getUser(int id){
        return userControllerMap.get(id);
    }
}
