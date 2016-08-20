package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.Beverages;
import com.vahtakiss.classes.basement.Sweet;

import java.util.ArrayList;
import java.util.List;

public class Cocoa implements Beverage, Sweet {
    private List<String> description = new ArrayList<String>();
    private double       price       = 6;
    private int spoonsOfSugar;

    public Cocoa(int spoonsOfSugar) {
        this.spoonsOfSugar = spoonsOfSugar;
        description.add(Beverages.COCOA.toString().toLowerCase());
        description.add(String.valueOf(spoonsOfSugar));
    }

    @Override
    public List<String> getDescription( ) {
        return description;
    }

    @Override
    public double getCost( ) {
        return price;
    }

    @Override
    public int getSugarAmount( ) {
        return spoonsOfSugar;
    }
}
