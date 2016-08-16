package com.vahtakiss.classes;

import com.vahtakiss.classes.supplements.Milk;
import com.vahtakiss.classes.supplements.Nuts;
import com.vahtakiss.classes.supplements.Syrup;
import com.vahtakiss.classes.supplements.Zephyr;
import com.vahtakiss.classes.typesofcoffee.*;
import com.vahtakiss.classes.utils.Parser;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeverageFactory {

    public List<Beverage> createBeverages(HttpServletRequest req) {
        List<Beverage> beverages = new ArrayList<Beverage>();

        int count = Integer.parseInt(req.getParameter("count"));

        for (int i = 0; i < count; i++) {
            Beverage beverage = createBeverage(Parser.httpReqToMap(req, i));
            if (beverage != null)
                beverages.add(beverage);
        }

        return beverages;
    }

    public Beverage createBeverage(Map<String, String> req) {
        Beverage beverage;
        Supplements[] supplements = Supplements.values();

        String coffee = req.get("coffee");
        int    sugar  = Integer.parseInt(req.get("sugar"));

        beverage = createMainBeverage(coffee, sugar);
        if (beverage == null)
            return beverage;

        for (int i = 0; i < supplements.length; i++) {
            String request = req.get(supplements[i].toString().toLowerCase());
            if (request.equals("1"))
                beverage = addSupplements(beverage, supplements[i]);
        }

        return beverage;
    }

    private Beverage createMainBeverage(String coffee, int sugar) {
        coffee = coffee.toUpperCase();
        switch (Beverages.valueOf(coffee)) {
            case LATTE:
                return new Latte(sugar);
            case FRAPPUCCINO:
                return new Frappuccino(sugar);
            case ESPRESSO:
                return new Espresso(sugar);
            case COCOA:
                return new Cocoa(sugar);
            case CAPPUCCINO:
                return new Cappuccino(sugar);
            case AMERICANO:
                return new Americano(sugar);
            default:
                return null;
        }
    }

    private Beverage addSupplements(Beverage in, Supplements supplement) {
        switch (supplement) {
            case MILK:
                return new Milk(in);
            case NUTS:
                return new Nuts(in);
            case SYRUP:
                return new Syrup(in);
            case ZEPHYR:
                return new Zephyr(in);
        }

        return null;
    }

}
