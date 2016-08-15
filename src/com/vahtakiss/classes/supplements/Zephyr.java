package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;
import com.vahtakiss.classes.Supplements;

import java.util.List;

public class Zephyr implements SupplementDecorator{
    private double price = 2.35;
    Beverage beverage;

    public Zephyr(Beverage beverage) {
        this.beverage = beverage;
        beverage.getDescription().add(Supplements.ZEPHYR.toString().toLowerCase());
    }

    @Override
    public List<String> getDescription( ) {
        return beverage.getDescription();
    }

    @Override
    public double cost( ) {
        return beverage.cost() + price;
    }
}
