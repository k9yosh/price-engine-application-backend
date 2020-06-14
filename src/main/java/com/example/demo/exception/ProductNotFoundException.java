package com.example.demo.exception;

/**
 * Exception class that handles errors when product is not available
 *
 * @author YomalM
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int productID) {
        super("Product is not available for " + productID);
    }
}
