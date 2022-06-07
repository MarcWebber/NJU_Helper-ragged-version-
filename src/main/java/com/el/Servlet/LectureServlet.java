package com.el.Servlet;

import com.alibaba.fastjson.JSONObject;
import com.el.CareTaker.LectureCareTaker;
import com.el.CareTaker.NewsCareTaker;
import com.el.CareTaker.UserCareTaker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/6
 * @ Description:
 * Life is short, I use Java
 */
public class LectureServlet extends HttpServlet {
    private List<JSONObject> getLectures(String deptName) {
        return LectureCareTaker.lectureControllerMap.get(deptName).getLectureJSON();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> deptList=null;
        deptList= UserCareTaker.getUser(Integer.parseInt(req.getSession().getAttribute("Id").toString())).getDepts();
        deptList.forEach(s->{
            try {
                System.out.println("trying to get lectures "+s);
                resp.getWriter().print(this. getLectures(s));
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("getting lecture failure "+s);
            }
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
