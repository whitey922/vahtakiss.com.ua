package com.vahtakiss.classes.utils;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.BeverageFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Order {
    private HttpServletRequest req;
    private String             userId;
    private String             userHostel;
    private String             userRoom;
    private BeverageFactory    factory;
    private List<Beverage>     beverages;
    private String             description;
    private User               user;

    public Order(HttpServletRequest req) {
        this.req = req;

        userId = getUserID(req);
        userHostel = req.getParameter("hostel");
        userRoom = req.getParameter("room");
        user = new User(userId, userHostel, userRoom);

        factory = new BeverageFactory();
        beverages = factory.createBeverages(req);
        description = req.getParameter("description");
    }

    public void sendEmail(String ... recipient) {
        OrderToEmail orderToEmail = new OrderToEmail(beverages, user, description);
        orderToEmail.sendOrder(recipient);
    }

    public List<Beverage> getBeverages( ) {
        return beverages;
    }

    class User {
        private String LINK_PREFIX = "https://new.vk.com/id";
        private String userLink ;
        private String hostel;
        private String room;

        User(String userID, String hostel, String room) {
            this.userLink = userID == null ? "default" : LINK_PREFIX + userID;
            this.hostel = hostel == null ? "Giant" : hostel;
            this.room = room == null ? "4806" : room;
        }

        public String getUserLink( ) {
            return userLink;
        }

        public String getHostel( ) {
            return hostel;
        }

        public String getRoom( ) {
            return room;
        }
    }



    private String getUserID(HttpServletRequest req) {
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
}
