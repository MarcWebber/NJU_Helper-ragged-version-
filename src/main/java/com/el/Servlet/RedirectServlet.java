package com.el.Servlet;

import com.el.CareTaker.UserCareTaker;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/6
 * @ Description:
 * Life is short, I use Java
 */
public class RedirectServlet extends HttpServlet {
    @Override
    // to prevent from illegual visit
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        if (req.getSession().getAttribute("Id")==null){
            System.err.println("illegual visit");
            /*
             * @BUG!!!!
             * redirect failure!
             * but this code is executed!
             * AGH?
             */
            try {
                resp.sendRedirect("index.jsp");
                System.err.println("send redirect");
            }catch (IOException e){
                System.err.println("redirect failure");
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
