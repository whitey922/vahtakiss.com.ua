package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;

public class Zephyr implements SupplementDecorator{
    private double price = 2.35;
    Beverage beverage;

    public Zephyr(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription( ) {
        return beverage.getDescription() + ", Zephyr";
    }

    @Override
    public double cost( ) {
        return beverage.cost() + price;
    }
}
