package com.vahtakiss.servlets;

import com.vahtakiss.classes.basement.Beverage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletOrderIntercept extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int            count     = Integer.parseInt(req.getParameter("count"));
        List<Beverage> orderList = new ArrayList<Beverage>();

//        for (int current = 0; current < count; current++) {
//            orderList.add(Beverage.createCoffee(req, current));
//        }

        String            url = "/caughtOrder.jsp";
        ServletContext    sc  = getServletContext();
        RequestDispatcher rd  = sc.getRequestDispatcher(url);

        req.setAttribute("orderList", orderList);
        rd.forward(req, resp);
    }



}
