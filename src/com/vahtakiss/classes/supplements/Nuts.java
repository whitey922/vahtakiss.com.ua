package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;
import com.vahtakiss.classes.Supplements;

import java.util.List;

public class Nuts implements SupplementDecorator{
    private double price = 1.35;
    Beverage beverage;

    public Nuts(Beverage beverage) {
        this.beverage = beverage;
        beverage.getDescription().add(Supplements.NUTS.toString().toLowerCase());
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
