package com.coders.helpers;

import com.coders.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FakeProductGeneratorTest {
private FakeProductGenerator fakeProductGenerator;


    @Test
    void generateProduct_ShouldCreateProductWithValidData() {
        FakeProductGenerator fakeProductGenerator = new FakeProductGenerator();
        Product product = fakeProductGenerator.generateFakeProduct();
        System.out.println(product);
        assertNotNull(product);
        assertNotNull(product.getName());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) >= 0);
    }

    @Test
    void generateProducts_ShouldCreateListOfProducts() {
        FakeProductGenerator fakeProductGenerator = new FakeProductGenerator();
        int count = 10;
        List<Product> products = fakeProductGenerator.generateFakeProducts(count);
        assertNotNull(products);
        assertEquals(count, products.size());
        for (Product product : products) {
            System.out.println(product);
            assertNotNull(product.getName());
            assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) >= 0);
        }
    }
}