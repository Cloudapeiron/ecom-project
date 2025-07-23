package com.inductive.ecom.service;

import com.inductive.ecom.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        return Arrays.asList(
            new Product(1L, "Laptop", 999.99),
            new Product(2L, "Smartphone", 499.49),
            new Product(3L, "Tablet", 299.99)
        );
    }
}
