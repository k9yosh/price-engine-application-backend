package com.example.demo;

import com.example.demo.config.PriceEngineConfig;
import com.example.demo.engine.model.OptimalPrice;
import com.example.demo.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PriceCalculationTests {

    @Autowired
    private PriceService priceService;

    @Autowired
    private PriceEngineConfig pec;

    @Test
    public void priceCalculatedForIncrementsOfUnitsTest() {

        OptimalPrice optimalPrice = priceService.calculateOptimalPrice(1,1,0);
        assertEquals(optimalPrice.getFinalPrice(), 11.38, "Must return 11.38");

        optimalPrice = priceService.calculateOptimalPrice(1,3,0);
        assertEquals(optimalPrice.getFinalPrice(), 34.13, "Must return 34.13");

        optimalPrice = priceService.calculateOptimalPrice(1,10,0);
        assertEquals(optimalPrice.getFinalPrice(), 113.75, "Must return 113.75");

    }

    @Test
    public void priceCalculatedForIncrementsOfCartonsTest() {

        OptimalPrice optimalPrice = priceService.calculateOptimalPrice(1,0,1);
        assertEquals(optimalPrice.getFinalPrice(), 175.00, "Must return 175.00");

        optimalPrice = priceService.calculateOptimalPrice(1,0,2);
        assertEquals(optimalPrice.getFinalPrice(), 350.00, "Must return 350.00");

    }

    @Test
    public void cartonDiscountAppliedAtGivenCartonNumberTest() {

        OptimalPrice optimalPrice = priceService.calculateOptimalPrice(1,0,1);
        assertEquals(optimalPrice.getFinalPrice(), 175.00, "Must return 175.00");

        optimalPrice = priceService.calculateOptimalPrice(1,0, pec.getCarton().getDiscountAppliesAt());
        assertEquals(optimalPrice.getFinalPrice(), 472.50, "Must return 472.50");

        optimalPrice = priceService.calculateOptimalPrice(2,0, pec.getCarton().getDiscountAppliesAt());
        assertEquals(optimalPrice.getFinalPrice(), 2227.50, "Must return 2227.50");

    }

    @Test
    public void requestedUnitsConvertedToUnitAndCartonCombinationTest() {

        OptimalPrice optimalPrice = priceService.calculateOptimalPrice(1,23,0);
        assertEquals(optimalPrice.getFinalPrice(), 209.13, "Must return 209.13");
        assertEquals(optimalPrice.getUnits(), 3, "Must be 3");
        assertEquals(optimalPrice.getCartons(), 1, "Must be 1");

        optimalPrice = priceService.calculateOptimalPrice(2,50,0);
        assertEquals(optimalPrice.getFinalPrice(), 7425.00, "Must return 7425.00");
        assertEquals(optimalPrice.getUnits(), 0, "Must be 0");
        assertEquals(optimalPrice.getCartons(), 10, "Must be 10");

    }

    @Test
    public void returnPricesForAGivenProductQuantityTest() {

        List<OptimalPrice> optimalPrices = priceService.calculateOptimalPricesByProductQuantity(1, 20);
        assertEquals(optimalPrices.size(), 20, "Array size must be 20");

        optimalPrices = priceService.calculateOptimalPricesByProductQuantity(1, 50);
        assertEquals(optimalPrices.size(), 50, "Array size must be 50");

    }

}
