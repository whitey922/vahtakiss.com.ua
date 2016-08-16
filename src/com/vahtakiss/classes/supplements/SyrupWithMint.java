package com.vahtakiss.classes.supplements;

import com.vahtakiss.classes.Beverage;
import com.vahtakiss.classes.SupplementDecorator;
import com.vahtakiss.classes.Supplements;

import java.util.List;

public class SyrupWithMint implements SupplementDecorator {
    private double price = 0.35;
    Beverage beverage;

    public SyrupWithMint(Beverage beverage) {
        this.beverage = beverage;
        beverage.getDescription().
                add(Supplements.SYRUP_WITH_MINT.toString().toLowerCase());
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
