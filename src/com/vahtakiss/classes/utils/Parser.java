package com.vahtakiss.classes.utils;

import com.vahtakiss.classes.Supplements;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, String> httpReqToMap(HttpServletRequest req, int current) {
        HashMap<String, String> reqMap = new HashMap<String, String>();

        String coffee = req.getParameter("coffee" + current);
        reqMap.put("coffee", coffee);

        int sugar = Integer.parseInt(req.getParameter("sugar" + current));
        reqMap.put("sugar", String.valueOf(sugar));

        Supplements[] supplements = Supplements.values();

        for (int i = 0; i < supplements.length; i++) {
            reqMap.put(supplements[i].toString().toLowerCase(), "off");
        }

        for (int i = 0; i < supplements.length; i++) {
            String request = req.getParameter(supplements[i].toString().toLowerCase() + current);
            if (request != null)
                if (request.equals("on"))
                    reqMap.put(supplements[i].toString().toLowerCase(), "on");
        }

        return reqMap;
    }
}
