package com.example.demo.controller;

import com.example.demo.engine.model.OptimalPrice;
import com.example.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/price")
public class PricingController {

    @Autowired
    private PriceService priceService;

    @GetMapping(path = "/product/optimalPrice/{id}")
    public ResponseEntity<OptimalPrice> calculateOptimalPrice(@PathVariable("id") int id, @RequestParam int units, @RequestParam int cartons) {
        OptimalPrice optimalPrice = priceService.calculateOptimalPrice(id, units, cartons);
        return new ResponseEntity<>(optimalPrice, HttpStatus.OK);
    }

    @GetMapping(path = "/product/optimalPriceProductQuantity/{id}")
    public ResponseEntity<List<OptimalPrice>> calculateOptimalPricesByProductQuantity(@PathVariable("id") int id, @RequestParam int quantity) {
        List<OptimalPrice> optimalPrices = optimalPrices = priceService.calculateOptimalPricesByProductQuantity(id, quantity);
        return new ResponseEntity<>(optimalPrices, HttpStatus.OK);
    }

}
