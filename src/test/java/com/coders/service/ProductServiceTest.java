package com.coders.service;

import com.coders.domain.Product;
import com.coders.exceptions.NoDataException;
import com.coders.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void testGetAllProducts() {
        Map<Integer, Product> productMap = new HashMap<>();
        Product product1 = new Product(1, "Product1", BigDecimal.valueOf(100), 20);
        Product product2 = new Product(2, "Product2", BigDecimal.valueOf(50), 10);

        productMap.put(product1.getId(), product1);
        productMap.put(product2.getId(), product2);

        when(productRepository.getAllProducts()).thenReturn(productMap);

        Map<Integer, Product> allProductsFromService = productService.getAllProducts();
        assertEquals(productMap, allProductsFromService);
    }

    @Test
    public void testGetAllProductsNoData() throws NoDataException {
        assertThrows(NoDataException.class, () -> productService.getAllProducts());
    }
}




