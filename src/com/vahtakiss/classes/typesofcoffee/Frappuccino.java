package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.Beverages;
import com.vahtakiss.classes.basement.Sweet;

import java.util.ArrayList;
import java.util.List;

public class Frappuccino implements Beverage, Sweet {
    private List<String> description = new ArrayList<String>();
    private double       price       = 11.45;
    private int spoonsOfSugar;

    public Frappuccino(int spoonsOfSugar) {
        this.spoonsOfSugar = spoonsOfSugar;
        description.add(Beverages.FRAPPUCCINO.toString().toLowerCase());
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
