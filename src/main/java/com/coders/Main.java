package com.coders;

import com.coders.helpers.FakeProductGenerator;
import com.coders.service.ProductService;
import com.coders.service.UserService;
import com.coders.view.AdminMainMenu;
import com.coders.view.MainMenu;
import com.coders.view.UserMainMenu;

public class Main {
    public static void main(String[] args) {
        FakeProductGenerator fakeProductGenerator = new FakeProductGenerator();
        fakeProductGenerator.initProduct();
        MainMenu mainMenu = new MainMenu();
        mainMenu.display();
    }
}