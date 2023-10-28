package com.coders.repository;

import com.coders.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product newProduct;
    private Product product1;
    private Product product2;
    private Map<Integer, Product> products;

    @BeforeEach
    void setUp() {
        productRepository = ProductRepository.getInstance();
    }

    @Test
    void addProduct() {
        Product product = new Product("TestProduct", BigDecimal.valueOf(25), 50);
        productRepository.addProduct(product);
        Product retrievedProduct = productRepository.getProductById(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals("TestProduct", retrievedProduct.getName());
        assertEquals(BigDecimal.valueOf(25), retrievedProduct.getPrice());
        assertEquals(50, retrievedProduct.getQuantity());
    }

    @Test
    void getProduct() {
        Product product = new Product("TestProduct", BigDecimal.valueOf(25), 50);
        productRepository.addProduct(product);

        Product retrievedProduct = productRepository.getProductById(product.getId());

        assertNotNull(retrievedProduct);
        assertEquals(product.getId(), retrievedProduct.getId());
        assertEquals(product.getName(), retrievedProduct.getName());
        assertEquals(product.getPrice(), retrievedProduct.getPrice());
        assertEquals(product.getQuantity(), retrievedProduct.getQuantity());
    }

    @Test
    void getAllProducts() {
        Product product1 = new Product("Product1", BigDecimal.valueOf(10), 100);
        Product product2 = new Product("Product2", BigDecimal.valueOf(20), 50);
        Product product3 = new Product("Product3", BigDecimal.valueOf(15), 75);

        productRepository.addProduct(product1);
        productRepository.addProduct(product2);
        productRepository.addProduct(product3);

        Map<Integer, Product> allProducts = productRepository.getAllProducts();

        assertNotNull(allProducts);
        assertEquals(3, allProducts.size());

        assertTrue(allProducts.containsKey(product1.getId()));
        assertTrue(allProducts.containsKey(product2.getId()));
        assertTrue(allProducts.containsKey(product3.getId()));
    }

    @Test
    void clearProductById() {
        Product product1 = new Product("Product1", BigDecimal.valueOf(10), 100);
        Product product2 = new Product("Product2", BigDecimal.valueOf(20), 50);
        Product product3 = new Product("Product3", BigDecimal.valueOf(15), 75);

        productRepository.addProduct(product1);
        productRepository.addProduct(product2);
        productRepository.addProduct(product3);

        productRepository.removeProductById(product2.getId());

        assertNull(productRepository.getProductById(product2.getId()));
        assertNotNull(productRepository.getProductById(product1.getId()));
        assertNotNull(productRepository.getProductById(product3.getId()));
    }
}