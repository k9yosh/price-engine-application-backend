package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class that manages product related data
 *
 * @author YomalM
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product getProductById(int id);

    List<Product> findAll();

}
