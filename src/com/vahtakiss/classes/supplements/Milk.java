package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.SupplementDecorator;
import com.vahtakiss.classes.basement.Supplements;
import com.vahtakiss.classes.basement.SupportMilk;

import java.util.List;

public class Milk implements SupplementDecorator{
    private double price = 0.75;
    Beverage beverage;

    public Milk(Beverage beverage) {
        if (beverage instanceof SupportMilk)
            initMilk((SupportMilk) beverage);
        else
            initMilk(beverage);
    }

    private void initMilk(SupportMilk beverage) {
        this.beverage = beverage;
        beverage.getDescription().add(Supplements.MILK.toString().toLowerCase());
    }

    private void initMilk(Beverage beverage) {
        this.beverage = beverage;
        price = 0;
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
