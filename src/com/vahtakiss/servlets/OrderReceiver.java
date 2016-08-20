package com.vahtakiss.servlets;

import com.vahtakiss.classes.utils.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderReceiver extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Order order = new Order(req);
        order.sendEmail();

        PrintWriter writer = resp.getWriter();

        for (int i = 0; i < order.getBeverages().size(); i++) {
            writer.println(order.getBeverages().get(i).getDescription());
            writer.println(order.getBeverages().get(i).getCost());
        }

//        String            url = "/orderInProcessed.jsp";
//        ServletContext    sc  = getServletContext();
//        RequestDispatcher rd  = sc.getRequestDispatcher(url);
//        rd.forward(req, resp);
    }
}