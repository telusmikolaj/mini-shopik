package com.coders.service;

import com.coders.domain.Product;
import com.coders.exceptions.NoDataException;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private Map<Integer, Product> productMap;

    public ProductService(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    public Map<Integer, Product> getAllProducts() throws NoDataException {
        if (productMap.isEmpty()) {
            throw new NoDataException("No products available.");
        }
        return new HashMap<>(productMap);
    }
}
