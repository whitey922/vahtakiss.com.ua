package com.vahtakiss.classes.typesofcoffee;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.Beverages;
import com.vahtakiss.classes.basement.SupportMilk;
import com.vahtakiss.classes.basement.Sweet;

import java.util.ArrayList;
import java.util.List;

public class Americano implements Beverage, Sweet, SupportMilk {
    private List<String> description = new ArrayList<String>();
    private double       price       = 12.45;
    private int spoonsOfSugar;

    public Americano(int spoonsOfSugar) {
        this.spoonsOfSugar = spoonsOfSugar;
        description.add(Beverages.AMERICANO.toString().toLowerCase());
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