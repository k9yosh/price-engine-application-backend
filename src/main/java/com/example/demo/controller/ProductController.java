package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> product = productService.getAllProducts();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
