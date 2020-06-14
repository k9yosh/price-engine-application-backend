package com.example.demo.engine.model;

import com.example.demo.model.Product;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptimalPrice extends OrderRequest {

    private int units; // No. of units for this price
    private int cartons; // No. of cartons for this price
    private double unitPrice;
    private double discount;
    private double finalPrice;

}
