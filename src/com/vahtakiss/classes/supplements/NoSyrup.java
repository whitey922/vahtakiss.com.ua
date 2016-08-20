package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.SupplementDecorator;
import com.vahtakiss.classes.basement.Supplements;

import java.util.List;

public class NoSyrup implements SupplementDecorator{
    private double price = 0;
    Beverage beverage;

    public NoSyrup(Beverage beverage) {
        this.beverage = beverage;
        beverage.getDescription().
                add(Supplements.NO_SYRUP.toString().toLowerCase());
    }

    @Override
    public List<String> getDescription( ) {
        return beverage.getDescription();
    }

    @Override
    public double getCost( ) {
        return beverage.getCost() + price;
    }
}
