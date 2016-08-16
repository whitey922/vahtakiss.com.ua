package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;
import com.vahtakiss.classes.Supplements;

import java.util.List;

public class SyrupWithRaspberry implements SupplementDecorator {
    private double price = 0.5;
    Beverage beverage;

    public SyrupWithRaspberry(Beverage beverage) {
        this.beverage = beverage;
        beverage.getDescription().
                add(Supplements.SYRUP_WITH_RASPBERRY.toString().toLowerCase());
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
