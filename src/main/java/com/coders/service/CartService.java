package com.coders.service;

import com.coders.domain.Cart;
import com.coders.domain.Product;
import com.coders.helpers.FakeCartFactoryGenerator;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private final Cart cart;
    private FakeCartFactoryGenerator fakeCartFactoryGenerator;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public List<Product> addToCart(int productId, int quantity) {
        addProduct(productId, quantity);
        return cart.getProductList();
    }

    private List<Product> addProduct(int productId, int quantity) {
        List<Product> productList = cart.getProductList();
        for (Product cartProduct : productList) {
            if (cartProduct.getId() == productId) {
                int currentQuantity = cartProduct.getQuantity();
                cartProduct.setQuantity(currentQuantity + quantity);
                return productList;
            }
        }
        return productList;
    }

    public String viewCart(List<Product> productList) {
        productList = new ArrayList<>();
        FakeCartFactoryGenerator fakeCartFactoryGenerator = new FakeCartFactoryGenerator();
        StringBuilder cartContent = new StringBuilder(String.format("ID: %d\nUser:\n   Username: %s\nProduct List:\n",
                fakeCartFactoryGenerator.generateFakeCart().getId(),
                fakeCartFactoryGenerator.generateFakeCart().getUser().getLogin()));


        productList = fakeCartFactoryGenerator.generateFakeCart().getProductList();
        for (Product product : productList) {
            cartContent.append(String.format("   Product ID: %d\n", product.getId()));
        }
        return cartContent.toString();
    }

    private String formatProducts(Product product) {
        String formattedProduct = "Name: " + product.getName() + "\n";

        return formattedProduct;
    }
}

