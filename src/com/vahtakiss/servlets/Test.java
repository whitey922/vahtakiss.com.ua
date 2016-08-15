package com.vahtakiss.servlets;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.BeverageFactory;
import com.vahtakiss.classes.utils.Parser;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test extends HttpServlet {
    public static PrintWriter writer;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String       id   = getCookie(req);
        final String link = "https://new.vk.com/id" + id;
        writer = resp.getWriter();

        BeverageFactory      factory = new BeverageFactory();
        final List<Beverage> order   = factory.createBeverages(req);

//        OrderToEmail orderToEmail = new OrderToEmail(order, link);
//        orderToEmail.sendOrder();

        for (Beverage bev : order) {
            System.out.println(Parser.beverageToMap(bev));
        }

//        String            url = "/orderInProcessed.jsp";
//        ServletContext    sc  = getServletContext();
//        RequestDispatcher rd  = sc.getRequestDispatcher(url);
//        rd.forward(req, resp);
    }

    private String getCookie(HttpServletRequest req) {
        String   result  = null;
        Cookie[] cookies = req.getCookies();

        if (cookies == null)
            return result;

        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals("uid"))
                result = c.getValue();
        }

        return result;
    }

    private static void test(Connection con,  String dbName) {
        List<Beverage> beverages = new ArrayList<Beverage>();
        BeverageFactory factory = new BeverageFactory();

        Statement stmt = null;
        String query = "select COF_NAME, SUP_ID, PRICE, " +
                "SALES, TOTAL " +
                "from " + dbName + ".COFFEES";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("coffee", rs.getString("coffee"));
                map.put("sugar", String.valueOf(rs.getInt("sugar")));
                map.put("milk", rs.getBoolean("milk") ? "on" : "off");
                map.put("nuts", rs.getBoolean("nuts") ? "on" : "off");
                map.put("syrup", rs.getBoolean("syrup") ? "on" : "off");
                map.put("zephyr", rs.getBoolean("zephyr") ? "on" : "off");
                beverages.add(factory.createBeverage(map));
            }
        } catch (SQLException e ) {

        } finally {

        }
    }

}
