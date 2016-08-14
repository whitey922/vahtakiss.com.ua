package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;

public class Milk implements SupplementDecorator{
    private double price = 0.75;
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription( ) {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost( ) {
        return beverage.cost() + price;
    }
}
