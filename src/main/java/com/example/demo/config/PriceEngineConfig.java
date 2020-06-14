package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "priceengine")
public class PriceEngineConfig {

    private Carton carton;
    private Unit unit;

    public Carton getCarton() {
        return carton;
    }

    public void setCarton(Carton carton) {
        this.carton = carton;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public static class Carton {
        private double discountMultiplier;
        private int discountAppliesAt;

        public double getDiscountMultiplier() {
            return discountMultiplier;
        }

        public void setDiscountMultiplier(double discountMultiplier) {
            this.discountMultiplier = discountMultiplier;
        }

        public int getDiscountAppliesAt() {
            return discountAppliesAt;
        }

        public void setDiscountAppliesAt(int discountAppliesAt) {
            this.discountAppliesAt = discountAppliesAt;
        }
    }

    public static class Unit {
        private double unitPriceMultiplier;

        public double getUnitPriceMultiplier() {
            return unitPriceMultiplier;
        }

        public void setUnitPriceMultiplier(double unitPriceMultiplier) {
            this.unitPriceMultiplier = unitPriceMultiplier;
        }
    }

}
