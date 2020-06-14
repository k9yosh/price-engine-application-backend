package com.example.demo.engine;

import com.example.demo.engine.model.OptimalPrice;

/**
 * Price implementation that acts as the base for a Optimal Price Calculation Request
 *
 * @author YomalM
 */
public class BasePriceImpl implements Price {

    @Override
    public OptimalPrice calculate(OptimalPrice optimalPrice) {
        return optimalPrice;
    }

}
