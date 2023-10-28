package com.coders.repository;

import com.coders.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class ProductRepository {

    private static ProductRepository INSTANCE;
    private Map<Integer, Product> productMap;
    private AtomicInteger idGenerator;

    private ProductRepository() {
        productMap = new HashMap<>();
        idGenerator = new AtomicInteger(1);
    }

    public static ProductRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductRepository();
        }

        return INSTANCE;
    }

    public void addProduct(Product product) {
        int productId = idGenerator.getAndIncrement();
        product.setId(productId);
        productMap.put(product.getId(), product);
    }

    public Product getProductById(int id) {
        return productMap.get(id);
    }

    public Map<Integer, Product> getAllProducts() {
        return productMap;
    }

    public void removeProductById(int id) {
        productMap.remove(id);
    }
}