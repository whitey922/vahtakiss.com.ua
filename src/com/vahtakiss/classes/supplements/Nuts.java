package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;

public class Nuts implements SupplementDecorator{
    private double price = 1.35;
    Beverage beverage;

    public Nuts(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription( ) {
        return beverage.getDescription() + ", Nuts";
    }

    @Override
    public double cost( ) {
        return beverage.cost() + price;
    }
}
