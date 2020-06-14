package com.example.demo;

import com.example.demo.engine.model.OptimalPrice;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductTests {

    @Autowired
    private ProductService productService;

    @Test
    public void returnAProductForAGivenIDTest() {

        Product compare = new Product();
        compare.setId(1);
        compare.setName("Penguine-Ears");
        compare.setCartonPrice(175.00);
        compare.setCartonUnits(20);

        Product product = productService.getProduct(1);
        assertEquals(product, compare, "Two objects must not be equal");

        compare.setId(2);
        compare.setName("Horseshoe");
        compare.setCartonPrice(825.00);
        compare.setCartonUnits(5);

        assertNotEquals(product, compare, "Two objects must not be equal");

        product = productService.getProduct(2);
        assertEquals(product, compare, "Two objects must not be equal");

    }

    @Test
    public void returnAllAvailableProductsTest() {

        List<Product> products = productService.getAllProducts();
        assertEquals(products.size(), 2, "Must be 2");

    }

}
