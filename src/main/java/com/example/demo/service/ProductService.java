package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class that caters for product related functions
 *
 * @author YomalM
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product getProduct(int id) {
        return productRepo.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

}
