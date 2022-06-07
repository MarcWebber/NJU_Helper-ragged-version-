package com.el.Servlet;

import com.el.CareTaker.ActivityCareTaker;
import com.el.CareTaker.LectureCareTaker;
import com.el.CareTaker.NewsCareTaker;
import com.el.CareTaker.UserCareTaker;
import com.el.User.UserController;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/4
 * @ Description:
 * Life is short, I use Java
 * to initialize all the information of a user
 */
public class Initializer {
    public static void init(int Id){
        UserCareTaker.appendUser(Id);
        UserCareTaker.getUser(Id).getDepts().forEach(NewsCareTaker::appendDept);
        UserCareTaker.getUser(Id).getDepts().forEach(ActivityCareTaker::appendDept);
        UserCareTaker.getUser(Id).getDepts().forEach(LectureCareTaker::appendDept);
    }
}
