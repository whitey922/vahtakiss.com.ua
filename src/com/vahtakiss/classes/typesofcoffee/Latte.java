package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.Sweet;

public class Latte implements Beverage, Sweet{
    private String description = "Latte";
    private double price = 9.5;
    private int spoonsOfSugar;

    public Latte(int spoonsOfSugar) {
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
