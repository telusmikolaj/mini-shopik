package com.coders.helpers;

import com.coders.domain.Cart;
import com.coders.domain.Product;
import com.coders.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FakeCartFactoryGeneratorTest {

    @Test
    public void testGenerateFakeCart() {
        FakeCartFactoryGenerator cartGenerator = new FakeCartFactoryGenerator();
        Cart fakeCart = cartGenerator.generateFakeCart();
        System.out.println("Generated Fake Cart:");
        formatCart(fakeCart);
    }

    private void formatCart(Cart cart) {
        System.out.println("ID: " + cart.getId());
        System.out.println("User:");
        formatUser(cart.getUser());
        System.out.println("Product List:");
        formatProductList(cart.getProductList());
    }

    private void formatUser(User user) {
        System.out.println("   Username: " + user.getLogin());
    }

    private void formatProductList(List<Product> productList) {
        for (Product product : productList) {
            System.out.println("   Product ID: " + product.getId());
        }
    }
}