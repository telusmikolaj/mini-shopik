package com.coders;

import com.coders.helpers.FakeCartFactoryGenerator;
import com.coders.helpers.FakeProductGenerator;
import com.coders.view.MainMenu;

public class Main {
    public static void main(String[] args) {
        FakeProductGenerator fakeProductGenerator = new FakeProductGenerator();
        fakeProductGenerator.initProduct();
        FakeCartFactoryGenerator fakeCartFactoryGenerator = new FakeCartFactoryGenerator();
        fakeCartFactoryGenerator.generateFakeCart();
        MainMenu mainMenu = new MainMenu();
        mainMenu.display();

    }
}