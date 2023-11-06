package com.coders.service;

import com.coders.domain.Product;
import com.coders.exceptions.NoDataException;
import com.coders.repository.ProductRepository;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<Integer, Product> getAllProducts() throws NoDataException {
        Map<Integer, Product> productMap = productRepository.getAllProducts();
        if (productMap == null || productMap.isEmpty()) {
            throw new NoDataException("No products available.");
        }
        return new HashMap<>(productMap);
    }
}
