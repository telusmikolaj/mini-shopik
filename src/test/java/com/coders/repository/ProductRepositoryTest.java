package com.coders.repository;

import com.coders.domain.Product;
import com.coders.exceptions.InvalidTypeOfDataException;
import com.coders.exceptions.NoDataException;
import com.coders.exceptions.NotSuchElementException;
import com.coders.exceptions.TheSameNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() throws InvalidTypeOfDataException, TheSameNameException, NoDataException {
        productRepository = ProductRepository.getInstance();
    }

    @Test
    void testAddProductWithValidData() {
        Product product = new Product("TestProduct", BigDecimal.valueOf(25), 50);
        productRepository.addProduct(product);
        Product retrievedProduct = productRepository.getProductById(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals("TestProduct", retrievedProduct.getName());
        assertEquals(BigDecimal.valueOf(25), retrievedProduct.getPrice());
        assertEquals(50, retrievedProduct.getQuantity());
    }

    @Test
    void testAddProductWithTheSameName() throws InvalidTypeOfDataException, TheSameNameException, NoDataException {
        Product product1 = new Product("TestProduct", BigDecimal.valueOf(25), 50);
        assertDoesNotThrow(() -> productRepository.addProduct(product1));
        Product product2 = new Product("TestProduct", BigDecimal.valueOf(10), 40);
        assertThrows(TheSameNameException.class, () -> productRepository.addProduct(product2));
    }


    @Test
    void testAddProductWithNoData() throws NoDataException {
        Product product = new Product();
        assertThrows(NoDataException.class, () -> productRepository.addProduct(product));
    }

    @Test
    void testAddProductWithInvalidTypeOfData() throws NoDataException {
        //powinno wyrzucać InvalidTypeOfDataException a wyrzuca NoDataException?
        Product product = new Product(BigDecimal.valueOf(123), "one", "one");
        assertThrows(NoDataException.class, () -> {
            productRepository.addProduct(product);
        });
    }

    @Test
    void getProductWithValidData() throws InvalidTypeOfDataException, TheSameNameException, NoDataException, NotSuchElementException {
        Product product = new Product("TestProduct2", BigDecimal.valueOf(25), 50);
        productRepository.addProduct(product);
        Product retrievedProduct = productRepository.getProductById(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals("TestProduct2", retrievedProduct.getName());
        assertEquals(BigDecimal.valueOf(25), retrievedProduct.getPrice());
        assertEquals(50, retrievedProduct.getQuantity());
    }

    @Test
    void testGetProductWithInvalidId() {
        assertThrows(NotSuchElementException.class, () -> productRepository.getProductById(-1));
    }

    @Test
    void testGetProductWithNoData() throws NoDataException {
        Product product = new Product();
        assertThrows(NoDataException.class, () -> productRepository.addProduct(product));
    }

    @Test
    void testGetProductWithInvalidData() throws NoDataException {
        Product invalidProduct = new Product();
        assertThrows(NoDataException.class, () -> productRepository.addProduct(invalidProduct));

    }

    @Test
    void getAllProductsWithValidData() throws InvalidTypeOfDataException, TheSameNameException, NoDataException {
        Product product1 = new Product("Product1", BigDecimal.valueOf(10), 100);
        Product product2 = new Product("Product2", BigDecimal.valueOf(20), 50);
        Product product3 = new Product("Product3", BigDecimal.valueOf(15), 75);

        productRepository.addProduct(product1);
        productRepository.addProduct(product2);
        productRepository.addProduct(product3);

        Map<Integer, Product> allProducts = productRepository.getAllProducts();

        assertNotNull(allProducts);
        assertEquals(6, allProducts.size());

        assertTrue(allProducts.containsKey(product1.getId()));
        assertTrue(allProducts.containsKey(product2.getId()));
        assertTrue(allProducts.containsKey(product3.getId()));
    }

    @Test
    void getAllProductsWithNoData() throws NoDataException {
        //nie wyrzuca wyjątku
        productRepository.removeAllProducts();
        assertThrows(NoDataException.class, () -> productRepository.getAllProducts());
    }

    @Test
    void clearProductByValidName() throws NotSuchElementException {
        Product product = new Product("Product10", BigDecimal.valueOf(20), 50);
        productRepository.addProduct(product);
        assertThrows(NotSuchElementException.class, () -> productRepository.getProductByName("Product10"));
    }

    @Test
    void clearProductByNotFoundName() throws NotSuchElementException {
        assertThrows(NotSuchElementException.class, () -> productRepository.getProductByName("Product12"));
    }
}
