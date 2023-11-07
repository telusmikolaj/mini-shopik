package com.coders;

import com.coders.helpers.FakeProductGenerator;
import com.coders.view.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.display();
        FakeProductGenerator fakeProductGenerator = new FakeProductGenerator();
        fakeProductGenerator.initProduct();
//        AdminMainMenu adminMainMenu = new AdminMainMenu();
//        adminMainMenu.display();


    }
}