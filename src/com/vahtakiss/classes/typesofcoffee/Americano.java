package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.Sweet;

public class Americano implements Beverage, Sweet {
    private String description = "Americano";
    private double price = 12.45;
    private int spoonsOfSugar;

    public Americano(int spoonsOfSugar) {
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
