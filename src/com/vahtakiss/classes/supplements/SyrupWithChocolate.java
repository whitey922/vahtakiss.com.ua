package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;
import com.vahtakiss.classes.Supplements;

import java.util.List;

public class SyrupWithChocolate implements SupplementDecorator {
    private double price = 0.9;
    Beverage beverage;

    public SyrupWithChocolate(Beverage beverage) {
        this.beverage = beverage;
        beverage.getDescription().
                add(Supplements.SYRUP_WITH_CHOCOLATE.toString().toLowerCase());
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
