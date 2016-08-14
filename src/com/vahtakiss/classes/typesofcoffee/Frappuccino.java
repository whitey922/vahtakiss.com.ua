package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.Sweet;

public class Frappuccino implements Beverage, Sweet {
    private String description = "Frappuccino";
    private double price = 11.45;
    private int spoonsOfSugar;

    public Frappuccino(int spoonsOfSugar) {
        this.spoonsOfSugar = spoonsOfSugar;
    }

    @Override
    public String getDescription( ) {
        return description + ", Sugar(" + spoonsOfSugar + ")";
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
