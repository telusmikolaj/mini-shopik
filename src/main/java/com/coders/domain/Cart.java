package com.coders.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {
    private int id;
    private User user;
    private List<Product> productList;

    public Cart(int id, User user, List<Product> productList) {
        this.id = id;
        this.user = user;
        this.productList = new ArrayList<>();
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(user, cart.user) && Objects.equals(productList, cart.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, productList);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", productList=" + productList +
                '}';
    }
}
