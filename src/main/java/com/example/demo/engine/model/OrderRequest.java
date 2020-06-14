package com.example.demo.engine.model;

import com.example.demo.model.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Product product;
    private int requestedUnits; // No. of units for this order
    private int requestedCartons; // No. of cartons for this order

}
