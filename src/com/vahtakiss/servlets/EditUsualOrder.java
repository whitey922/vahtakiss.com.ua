package com.vahtakiss.servlets;

import com.vahtakiss.classes.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Caesar on 15.08.2016.
 */
public class EditUsualOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DBConnection.getInstance().updateUsualOrder(req.getParameter("id"),req.getParameter("coffee"),
                    req.getParameter("sugar"), req.getParameter("milk"),
                    req.getParameter("nuts"), req.getParameter("zephyr"),
                    req.getParameter("syrup"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
