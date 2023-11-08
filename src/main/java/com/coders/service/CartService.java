package com.coders.service;

import com.coders.domain.Cart;
import com.coders.domain.Product;


import java.util.List;

public class CartService {
    private final Cart cart;

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
        productList = cart.getProductList();
        StringBuilder cartContent = new StringBuilder(String.format("%-20s | %-15s | %-15s\n", "Product", "Quantity", "Price"));
        for (Product product : productList) {
            String productName = String.format("%-20s", product.getName());
            String quantity = String.format("%-15s", product.getQuantity());
            String price = String.format("%-15s", product.getPrice());
            cartContent.append(productName).append(" | ").append(quantity).append(" | ").append(price).append("\n");
        }
        return cartContent.toString();
    }
}

