package com.coders.helpers;

import com.coders.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerator {

    private static final String[] PRODUCTS = { "Laptop", "Smartphone", "Tablet", "TV", "Camera" };
    private static final BigDecimal MIN_PRICE = BigDecimal.valueOf(100.0);
    private static final BigDecimal MAX_PRICE = BigDecimal.valueOf(2000.0);
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 10;

    private static int nextId = 1;

    public static Product generateProduct() {
        Random random = new Random();
        int id = random.nextInt();
        String name = PRODUCTS[random.nextInt(PRODUCTS.length)] ;
        BigDecimal price = MIN_PRICE.add(MAX_PRICE.subtract(MIN_PRICE).multiply(BigDecimal.valueOf(random.nextDouble())));

        price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        int quantity = MIN_QUANTITY + random.nextInt(MAX_QUANTITY - MIN_QUANTITY + 1);
        return new Product(id, name, price, quantity);
    }

    public static List<Product> generateProducts(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            products.add(generateProduct());
        }
        return products;
    }
}
