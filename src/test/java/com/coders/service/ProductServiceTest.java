package com.coders.service;

import com.coders.domain.Product;
import com.coders.exceptions.NoDataException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

//public class ProductServiceTest {
//
//    @InjectMocks
//    private ProductService productService;
//
//    @Mock
//    private Map<Integer, Product> productMap;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }

public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private Map<Integer, Product> productMap;

    @Before
    public void setUp() {
        productMap = new HashMap<>();
        productService = new ProductService(productMap);
    }

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product(1, "Product1", BigDecimal.valueOf(100), 20);
        Product product2 = new Product(2, "Product2", BigDecimal.valueOf(50), 10);

        productMap.put(1, product1);
        productMap.put(2, product2);

        Map<Integer, Product> result = productService.getAllProducts();
        System.out.println(productMap);
        assertTrue(!result.isEmpty());
        assertEquals(productMap, result);
    }

    @Test()
    public void testGetAllProductsNoData() throws NoDataException {
        assertThrows(NoDataException.class, () -> productService.getAllProducts());
    }
}

