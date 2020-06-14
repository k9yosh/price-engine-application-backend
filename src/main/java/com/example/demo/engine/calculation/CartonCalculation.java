package com.example.demo.engine.calculation;

import com.example.demo.config.PriceEngineConfig;
import com.example.demo.engine.OptimalPriceCalculator;
import com.example.demo.engine.Price;
import com.example.demo.engine.model.OptimalPrice;
import com.example.demo.util.BeanUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class for price calculation logic that calculates price of a cartons
 *
 * @author YomalM
 */
public class CartonCalculation extends OptimalPriceCalculator {

    private PriceEngineConfig pec;

    Logger logger = LogManager.getLogger(CartonCalculation.class);

    public CartonCalculation(Price price) {
        super(price);
        pec = BeanUtil.getBean(PriceEngineConfig.class);
    }

    public OptimalPrice calculate(OptimalPrice optimalPrice) {
        OptimalPrice currentPrice = super.calculate(optimalPrice);
        return calculateCartonPricing(currentPrice);
    }

    private OptimalPrice calculateCartonPricing(OptimalPrice optimalPrice) {

        logger.info("Applying carton calculation logic to current Optimal Pricing");

        optimalPrice.setCartons(optimalPrice.getCartons() + (optimalPrice.getUnits() / optimalPrice.getProduct().getCartonUnits()));
        optimalPrice.setUnits(optimalPrice.getUnits() % optimalPrice.getProduct().getCartonUnits());

        double cartonPrice;
        // 10% discount
        if (optimalPrice.getCartons() >= pec.getCarton().getDiscountAppliesAt()) {
            logger.info("Order Request eligible for carton discount");
            cartonPrice = optimalPrice.getProduct().getCartonPrice() - (optimalPrice.getProduct().getCartonPrice() * pec.getCarton().getDiscountMultiplier());
        } else {
            logger.info("Order Request is not eligible for carton discount");
            cartonPrice = optimalPrice.getProduct().getCartonPrice();
        }

        optimalPrice.setFinalPrice(optimalPrice.getCartons() * cartonPrice);

        return optimalPrice;
    }

}
