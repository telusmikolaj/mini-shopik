package com.coders.repository;

import com.coders.domain.Product;
import com.coders.exceptions.InvalidTypeOfDataException;
import com.coders.exceptions.NoDataException;
import com.coders.exceptions.NotSuchElementException;
import com.coders.exceptions.TheSameNameException;
import com.coders.helpers.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository productRepository;
    private ProductValidator productValidator;

    @BeforeEach
    void setUp() throws InvalidTypeOfDataException, TheSameNameException, NoDataException, NotSuchElementException {
        productRepository = ProductRepository.getInstance();
        productValidator = new ProductValidator();
    }

    @Test
    void testAddProductWithValidData() {
        Product product = new Product(1, "TestProduct", BigDecimal.valueOf(25), 50);
        productRepository.addProduct(product);
        Product retrievedProduct = productRepository.getProductById(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals("TestProduct", retrievedProduct.getName());
        assertEquals(BigDecimal.valueOf(25), retrievedProduct.getPrice());
        assertEquals(50, retrievedProduct.getQuantity());
    }

    @Test
    void testAddProductWithTheSameName() throws InvalidTypeOfDataException, TheSameNameException, NoDataException {
        Product product1 = new Product(2,"TestProduct", BigDecimal.valueOf(25), 50);
        assertDoesNotThrow(() -> productRepository.addProduct(product1));
        Product product2 = new Product(2,"TestProduct", BigDecimal.valueOf(10), 40);
        assertThrows(TheSameNameException.class, () -> productRepository.addProduct(product2));
    }

    @Test
    void testAddProductWithNoData() throws NoDataException {
        Product product = new Product();
        assertThrows(NoDataException.class, () -> productRepository.addProduct(product));
    }

    @Test
    void testAddProductWithInvalidTypeOfData() throws NoDataException {
        Product product = new Product(3, BigDecimal.valueOf(123), "one", "one");
        assertThrows(NoDataException.class, () -> {
            productRepository.addProduct(product);
        });
    }

    @Test
    void getProductWithValidData() throws InvalidTypeOfDataException, TheSameNameException, NoDataException, NotSuchElementException {
        Product product = new Product(4, "TestProduct2", BigDecimal.valueOf(25), 50);
        productRepository.addProduct(product);
        Product retrievedProduct = productRepository.getProductById(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals("TestProduct2", retrievedProduct.getName());
        assertEquals(BigDecimal.valueOf(25), retrievedProduct.getPrice());
        assertEquals(50, retrievedProduct.getQuantity());
    }

    @Test
    void testGetProductWithNoData() throws NoDataException {
        Product product = new Product();
        assertThrows(NoDataException.class, () -> productRepository.addProduct(product));
    }

    @Test
    void getAllProductsWithValidData() throws InvalidTypeOfDataException, TheSameNameException, NoDataException {
        Product product1 = new Product(5,"Product1", BigDecimal.valueOf(10), 100);
        Product product2 = new Product(6,"Product2", BigDecimal.valueOf(20), 50);
        Product product3 = new Product(7,"Product3", BigDecimal.valueOf(15), 75);

        productRepository.addProduct(product1);
        productRepository.addProduct(product2);
        productRepository.addProduct(product3);

        Map<Integer, Product> allProducts = productRepository.getAllProducts();

        assertNotNull(allProducts);
        assertEquals(5, allProducts.size());

        assertTrue(allProducts.containsKey(product1.getId()));
        assertTrue(allProducts.containsKey(product2.getId()));
        assertTrue(allProducts.containsKey(product3.getId()));
    }

    @Test
    void getAllProductsWithNoData() {
        productRepository.removeAllProducts();
        assertThrows(NoDataException.class, () -> productRepository.getAllProducts());
    }

    @Test
    void clearProductWithValidData() {
        Product product = new Product(8,"Product100", BigDecimal.valueOf(20), 50);
        productRepository.addProduct(product);
        Product removed = productRepository.removeProductById(product.getId());
        assertThrows(NotSuchElementException.class, () -> productRepository.removeProductById(6));

    }

    @Test
    void clearProductByNotFoundName() {
        assertThrows(NoDataException.class, () -> productRepository.removeProductByName("Product1000"));
    }
}
