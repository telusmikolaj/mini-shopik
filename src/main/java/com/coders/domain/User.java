package com.coders.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "USER")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String role;
    private BigDecimal accountBalance;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    public User(String firstName, String lastName, String login, String password, String role, BigDecimal accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
        this.accountBalance = accountBalance;
    }
}
