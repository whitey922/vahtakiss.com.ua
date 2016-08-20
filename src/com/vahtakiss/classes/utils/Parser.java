package com.vahtakiss.classes.utils;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.Supplements;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
            reqMap.put(supplements[i].toString().toLowerCase(), "0");
        }

        for (int i = 0; i < supplements.length; i++) {
            String request = req.getParameter(supplements[i].toString().toLowerCase() + current);
            if (request != null)
                if (request.equals("on"))
                    reqMap.put(supplements[i].toString().toLowerCase(), "1");
        }

        return reqMap;
    }

    public static HashMap<String, String> beverageToMap(Beverage beverage) {
        HashMap<String, String> bevMap = new HashMap<String, String>();

        List<String> description = beverage.getDescription();

        bevMap.put("coffee", description.get(0));
        bevMap.put("sugar", description.get(1));

        Supplements[] supplements = Supplements.values();
        for (int i = 0; i < supplements.length; i++) {
            bevMap.put(supplements[i].toString().toLowerCase(), "unchecked");
        }

        for (int i = 0; i < supplements.length; i++) {
            if (description.contains(supplements[i].toString().toLowerCase()))
                bevMap.put(supplements[i].toString().toLowerCase(), "checked");
        }

        return bevMap;
    }
}
