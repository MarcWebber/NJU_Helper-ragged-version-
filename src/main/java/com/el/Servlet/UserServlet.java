package com.el.Servlet;

import com.el.CareTaker.UserCareTaker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/4
 * @ Description:
 * Life is short, I use Java
 */
public class UserServlet extends HttpServlet {
    // to return the info of the user and load
    // it should carry the
    // it may be now deprecated
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getSession().getAttribute("Id").toString()+"is trying to get info");
        resp.getWriter().print(UserCareTaker.getUser(Integer.parseInt(req.getSession().getAttribute("Id").toString())).getUserInformationAsJson());
    }


    private void editName(HttpServletRequest req,HttpServletResponse resp){

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
