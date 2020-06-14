package com.example.demo.engine.calculation;

import com.example.demo.config.PriceEngineConfig;
import com.example.demo.engine.OptimalPriceCalculator;
import com.example.demo.engine.Price;
import com.example.demo.engine.model.OptimalPrice;
import com.example.demo.util.BeanUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for price calculation logic that calculates price of units
 *
 * @author YomalM
 */
public class SingleUnitCalculation extends OptimalPriceCalculator {

    private PriceEngineConfig pec;

    Logger logger = LogManager.getLogger(SingleUnitCalculation.class);

    public SingleUnitCalculation(Price price) {
        super(price);
        pec = BeanUtil.getBean(PriceEngineConfig.class);
    }

    public OptimalPrice calculate(OptimalPrice optimalPrice) {
        OptimalPrice currentPrice = super.calculate(optimalPrice);
        return calculateSingleUnitPricing(currentPrice);
    }

    private OptimalPrice calculateSingleUnitPricing(OptimalPrice optimalPrice) {

        logger.info("Applying unit calculation logic to current Optimal Pricing");

        if(optimalPrice.getUnits() > 0) {
            double singleUnitPrice  = optimalPrice.getProduct().getCartonPrice() / optimalPrice.getProduct().getCartonUnits() * pec.getUnit().getUnitPriceMultiplier();

            optimalPrice.setFinalPrice(
                    optimalPrice.getFinalPrice() + (optimalPrice.getUnits() * singleUnitPrice));
        }

        return optimalPrice;
    }

}
