package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.Sweet;

public class Cappuccino implements Beverage, Sweet {
    private String description = "Cappuccino";
    private double price = 8.79;
    private int spoonsOfSugar;

    public Cappuccino(int spoonsOfSugar) {
        this.spoonsOfSugar = spoonsOfSugar;
    }

    @Override
    public String getDescription( ) {
        return description  + ", Sugar(" + spoonsOfSugar + ")";
    }

    @Override
    public double cost( ) {
        return price;
    }

    @Override
    public int getSugarAmount( ) {
        return spoonsOfSugar;
    }
}
