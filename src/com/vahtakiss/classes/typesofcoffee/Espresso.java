package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.Sweet;

public class Espresso implements Beverage, Sweet {
    private String description = "Espresso";
    private double price = 8.75;
    private int spoonsOfSugar;

    public Espresso(int spoonsOfSugar) {
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
