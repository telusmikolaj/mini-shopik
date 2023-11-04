package com.coders.helpers;

import com.coders.domain.Product;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FakeProductGenerator {
    private final Faker faker;

    public FakeProductGenerator() {
        this.faker = new Faker();
    }

    public Product generateFakeProduct() {
        String name = faker.commerce().productName();
        BigDecimal price = BigDecimal.valueOf(faker.number().randomDouble(2, 100, 2000));
        int quantity = faker.number().numberBetween(1, 10);
        Product product = new Product(name, price, quantity);
        return product;
    }

    public List<Product> generateFakeProducts(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            products.add(generateFakeProduct());
        }
        return products;
    }
}
