package com.el.Servlet;

import com.alibaba.fastjson.JSONObject;
import com.el.CareTaker.ActivityCareTaker;
import com.el.CareTaker.LectureCareTaker;
import com.el.CareTaker.UserCareTaker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/6
 * @ Description:
 * Life is short, I use Java
 */
public class ActivityServlet extends HttpServlet {

    private List<JSONObject> getActivities(String deptName) {
        return ActivityCareTaker.activityControllerMap.get(deptName).getActivityJSON();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> deptList=null;
        deptList= UserCareTaker.getUser(Integer.parseInt(req.getSession().getAttribute("Id").toString())).getDepts();
        deptList.forEach(s->{
            try {
                System.out.println("trying to get activities "+s);
                resp.getWriter().print(this. getActivities(s));
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("getting activity failure "+s);
            }
        });
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
