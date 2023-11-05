package com.coders.helpers;

import com.coders.domain.Product;
import com.coders.repository.ProductRepository;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeProductGenerator {
    private final Faker faker;
    private final ProductRepository productRepository;
    private final ProductValidator productValidator;
    private final AtomicInteger idGenerator;

    public FakeProductGenerator() {
        this.faker = new Faker();
        productRepository = ProductRepository.getInstance();
        productValidator = new ProductValidator();
        idGenerator = new AtomicInteger(1);
    }

    public void initProduct() {
        Map<Integer, Product> fakeProducts = generateFakeProducts(10);
        for (Map.Entry<Integer, Product> entry : fakeProducts.entrySet()) {
            Product product = entry.getValue();
            productValidator.validate(product);
            productRepository.addProduct(product);
        }
    }

    public Product generateFakeProduct() {
        int id = idGenerator.getAndIncrement();
        String name = faker.commerce().productName();
        BigDecimal price = BigDecimal.valueOf(faker.number().randomDouble(2, 100, 2000));
        int quantity = faker.number().numberBetween(1, 10);
        Product product = new Product(id, name, price, quantity);
        return product;
    }

    public Map<Integer, Product> generateFakeProducts(int count) {
        Map<Integer, Product> productsMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int id = i;
            Product product = generateFakeProduct();
            productsMap.put(id, product);

        }
        return productsMap;
    }
}
