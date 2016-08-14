package com.vahtakiss.servlets;

/**
 * Created by Yegorov on 03.08.2016.
 */

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class VkAuth extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");

        Cookie cookie = new Cookie("uid", uid);
        cookie.setMaxAge(60 * 24 * 360);
        resp.addCookie(cookie);

        resp.sendRedirect("/index.jsp");

//        String url = "/index.jsp";
//
//        ServletContext    sc = getServletContext();
//        RequestDispatcher rd = sc.getRequestDispatcher(url);
//        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
