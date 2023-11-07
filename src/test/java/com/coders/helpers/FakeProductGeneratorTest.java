package com.coders.helpers;

import com.coders.domain.Product;
import com.coders.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FakeProductGeneratorTest {
    private FakeProductGenerator fakeProductGenerator;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = ProductRepository.getInstance();
        fakeProductGenerator = new FakeProductGenerator();
    }

    @Test
    void initProduct_shouldInitProductAndAddProductToMap() {
        fakeProductGenerator.initProduct();
        Map<Integer, Product> allProductsFromGenerator = productRepository.getAllProducts();
        assertFalse(allProductsFromGenerator.isEmpty());
        assertEquals(10, allProductsFromGenerator.size());
        for (Map.Entry<Integer, Product> entry : allProductsFromGenerator.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + " - " + entry.getValue());
        }
    }

    @Test
    void generateProduct_ShouldCreateProductWithValidData() {
        Product product = fakeProductGenerator.generateFakeProduct();
        System.out.println("Generated Product: " + product);
        assertNotNull(product);
        assertNotNull(product.getName());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) >= 0);
    }

    @Test
    void generateProducts_ShouldCreateListOfProducts() {
        int count = 10;
        Map<Integer, Product> products = fakeProductGenerator.generateFakeProducts(count);

        assertNotNull(products);
        assertEquals(count, products.size());

        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Integer productId = entry.getKey();
            Product product = entry.getValue();

            assertNotNull(product);

            System.out.println("Product ID: " + productId + " - Name: " + product.getName() + " - Price: " + product.getPrice() + " - Quantity: " + product.getQuantity());
        }
    }
}
