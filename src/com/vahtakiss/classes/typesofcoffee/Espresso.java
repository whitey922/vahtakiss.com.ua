package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.Beverages;
import com.vahtakiss.classes.Sweet;

import java.util.ArrayList;
import java.util.List;

public class Espresso implements Beverage, Sweet {
    private List<String> description = new ArrayList<String>();
    private double       price       = 8.75;
    private int spoonsOfSugar;

    public Espresso(int spoonsOfSugar) {
        this.spoonsOfSugar = spoonsOfSugar;
        description.add(Beverages.ESPRESSO.toString().toLowerCase());
        description.add(String.valueOf(spoonsOfSugar));
    }

    @Override
    public List<String> getDescription( ) {
        return description;
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
