package com.example.demo.engine;

import com.example.demo.engine.model.OptimalPrice;

/**
 * Interface for Optimal Price Calculation
 *
 * @author YomalM
 */
public interface Price {
    OptimalPrice calculate(OptimalPrice optimalPrice);
}
