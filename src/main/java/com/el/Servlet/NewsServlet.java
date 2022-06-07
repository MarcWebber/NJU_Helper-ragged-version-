package com.el.Servlet;

import com.alibaba.fastjson.JSONObject;
import com.el.CareTaker.NewsCareTaker;
import com.el.CareTaker.UserCareTaker;
import com.el.News.NewsController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/1
 * @ Description:
 * Life is short, I use Java
 */
@WebServlet(name = "NewsServlet", value = "/NewsServlet")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    private List<JSONObject> getNews(String deptName) {
        return NewsCareTaker.newsControllerMap.get(deptName).getNewsJSON();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> deptList=null;
        deptList=UserCareTaker.getUser(Integer.parseInt(req.getSession().getAttribute("Id").toString())).getDepts();
        deptList.forEach(s->{
            try {
                System.out.println("trying to get news "+s);
                resp.getWriter().print(this.getNews(s));
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("getting news failure "+s);
            }
        });
    }
}
