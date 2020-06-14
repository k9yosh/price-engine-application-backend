package com.example.demo.service;

import com.example.demo.engine.BasePriceImpl;
import com.example.demo.engine.Price;
import com.example.demo.engine.calculation.CartonCalculation;
import com.example.demo.engine.calculation.SingleUnitCalculation;
import com.example.demo.engine.model.OptimalPrice;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class that caters for price related functions
 *
 * @author YomalM
 */
@Service
public class PriceService {

    Logger logger = LogManager.getLogger(PriceService.class);

    @Autowired
    private ProductService productService;

    public List<OptimalPrice> calculateOptimalPricesByProductQuantity(int id, int quantity) {
        Product product = productService.getProduct(id);
        List<OptimalPrice> optimalPrices = new ArrayList<>();

        if (product != null) {
            logger.info("Product found for ID : " + id);

            for (int i = 1; i <= quantity; i++) {
                OptimalPrice initPrice = new OptimalPrice();
                initPrice.setProduct(product);
                initPrice.setUnits(i);
                initPrice.setRequestedUnits(i);

                Price price = new SingleUnitCalculation(new CartonCalculation(new BasePriceImpl()));

                OptimalPrice optimalPrice = price.calculate(initPrice);
                optimalPrice.setFinalPrice(Utility.round(optimalPrice.getFinalPrice(), 2));

                optimalPrices.add(optimalPrice);
            }

            logger.info(optimalPrices.size() + " Optimal Prices calculated!");

            return optimalPrices;
        } else {
            logger.error("Product not found! ID : " + id);
            throw new ProductNotFoundException(id);
        }

    }

    public OptimalPrice calculateOptimalPrice(int id, int units, int cartons) {

        Product product = productService.getProduct(id);

        OptimalPrice initPrice = new OptimalPrice();
        initPrice.setProduct(product);
        initPrice.setUnits(units);
        initPrice.setRequestedUnits(units);
        initPrice.setCartons(cartons);
        initPrice.setRequestedCartons(cartons);

        if (product != null) {
            Price price = new SingleUnitCalculation(new CartonCalculation(new BasePriceImpl()));

            OptimalPrice optimalPrice = price.calculate(initPrice);
            optimalPrice.setFinalPrice(Utility.round(optimalPrice.getFinalPrice(), 2));

            return optimalPrice;
        } else {
            logger.error("Product not found! ID : " + id);
            throw new ProductNotFoundException(id);
        }

    }

}
