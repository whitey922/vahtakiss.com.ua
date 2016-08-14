package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;

public class Syrup implements SupplementDecorator {
    private double price = 0.5;
    Beverage beverage;

    public Syrup(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription( ) {
        return beverage.getDescription() + ", Syrup";
    }

    @Override
    public double cost( ) {
        return beverage.cost() + price;
    }
}
