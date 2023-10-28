package com.coders.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "cart")
    private List<Product> productList;

    public Cart(User user, List<Product> productList) {
        this.user = user;
        this.productList = productList;
    }
}
