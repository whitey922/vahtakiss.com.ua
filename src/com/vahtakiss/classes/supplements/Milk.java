package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;
import com.vahtakiss.classes.Supplements;

import java.util.List;

public class Milk implements SupplementDecorator{
    private double price = 0.75;
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
        beverage.getDescription().add(Supplements.MILK.toString().toLowerCase());
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
