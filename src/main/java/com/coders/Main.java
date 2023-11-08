package com.coders;

import com.coders.domain.Cart;
import com.coders.helpers.FakeProductGenerator;
import com.coders.view.MainMenu;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        FakeProductGenerator fakeProductGenerator = new FakeProductGenerator();
        fakeProductGenerator.initProduct();
        MainMenu mainMenu = new MainMenu();
        mainMenu.display();

    }
}