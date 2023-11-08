package com.coders.service;

import com.coders.domain.Cart;
import com.coders.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CartServiceTest {
    @InjectMocks
    private CartService cartService;
    @Mock
    private Cart cart;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cartService = new CartService(cart);
    }

    @Test
    void addToCart() {
        getData();
        List<Product> updatedProductList = cartService.addToCart(2, 100);
        Product updatedProduct = updatedProductList.get(0);
        assertEquals(5, updatedProduct.getQuantity());
    }

    @Test
    void viewCart() {
        Product existingProduct1 = new Product(1, "Produkt 1", BigDecimal.valueOf(20.0), 5);
        Product existingProduct2 = new Product(2, "Produkt 2", BigDecimal.valueOf(20.0), 5);
        List<Product> productList = new ArrayList<>();
        productList.add(existingProduct1);
        productList.add(existingProduct2);
        when(cart.getProductList()).thenReturn(productList);
        String updated = cartService.viewCart(productList);
        System.out.println(updated);
        assertNotNull(updated);
    }

    private void getData() {
        Product existingProduct1 = new Product(1, "Produkt 1", BigDecimal.valueOf(20.0), 5);
        Product existingProduct2 = new Product(2, "Produkt 2", BigDecimal.valueOf(20.0), 5);
        List<Product> productList = new ArrayList<>();
        productList.add(existingProduct1);
        productList.add(existingProduct2);
        when(cart.getProductList()).thenReturn(productList);
    }
}