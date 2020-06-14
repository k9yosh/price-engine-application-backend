package com.example.demo.engine;

import com.example.demo.engine.model.OptimalPrice;
import com.example.demo.exception.ProductNotFoundException;

/**
 * Abstract class that implements a Price Calculator which applies calculation logic to a given OptimalPrice
 *
 * @author YomalM
 */
public abstract class OptimalPriceCalculator implements Price {

    private Price price;

    public OptimalPriceCalculator(Price price) {
        this.price = price;
    }

    @Override
    public OptimalPrice calculate(OptimalPrice optimalPrice) {
        return price.calculate(optimalPrice);
    }
}
