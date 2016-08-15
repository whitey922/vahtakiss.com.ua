package com.vahtakiss.servlets;

import com.vahtakiss.classes.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class VkAuth extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        Cookie cookie = new Cookie("uid", uid);
        cookie.setMaxAge(518400);
        resp.addCookie(cookie);

        try {
            DBConnection.getInstance().addUser(req.getParameter("uid"),
                    req.getParameter("first_name"),
                    req.getParameter("last_name"),
                    req.getParameter("photo"));
        } catch (SQLException var6) {
            var6.printStackTrace();
        } catch (ClassNotFoundException var7) {
            var7.printStackTrace();
        } catch (InstantiationException var8) {
            var8.printStackTrace();
        } catch (IllegalAccessException var9) {
            var9.printStackTrace();
        }

    }
}
