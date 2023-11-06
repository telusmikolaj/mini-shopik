package com.coders.helpers;

import com.coders.domain.Product;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductGeneratorTest {

    @Test
    void generateProduct_ShouldCreateProductWithValidData() {
        Product product = ProductGenerator.generateProduct();
        System.out.println(product);
        assertNotNull(product);
        assertNotNull(product.getName());
        assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) >= 0);
    }

    @Test
    void generateProducts_ShouldCreateListOfProducts() {
        int count = 10;
        List<Product> products = ProductGenerator.generateProducts(count);
        assertNotNull(products);
        assertEquals(count, products.size());
        for (Product product: products) {
            System.out.println(product);
            assertNotNull(product.getName());
            assertTrue(product.getPrice().compareTo(BigDecimal.ZERO) >= 0);
        }
    }
}