package com.coders.view;

import com.coders.service.UserService;

public class MainMenu extends Menu {
    @Override
    public void display() {
        boolean continueLoop = true;

        System.out.println("=== MENU LOGOWANIA ===");
        System.out.println("1. Zaloguj jako użytkownik");
        System.out.println("2. Zaloguj jako admin");
        System.out.println("3. Zarejestruj się");
        System.out.println("4. Wyjście");

        System.out.print("Wybierz opcję: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                userLogin();
                break;
            case 2:
                adminLogin();
                break;
            case 3:
                register();
                break;
            case 4:
                System.out.println("Zamykanie programu...");
                break;
            default:
                System.out.println("Nieznana opcja! Spróbuj ponownie.");
                break;
        }
    }

    private void userLogin() {
        System.out.print("Podaj login: ");
        String username = scanner.next();

        System.out.print("Podaj hasło: ");
        String password = scanner.next();

        // Tutaj logika do sprawdzenia czy użytkownik o podanym loginie i haśle istnieje
        // Jeśli tak, przechodzimy do głównego menu użytkownika
        // Jeśli nie, wyświetlamy odpowiedni komunikat i wracamy do menu logowania

        UserService userService = new UserService();
        UserMainMenu userMainMenu = new UserMainMenu();
        userMainMenu.display();

    }

    private void adminLogin() {
        // Podobna logika jak w przypadku logowania użytkownika, ale dla admina
    }

    private void register() {
        // Logika do rejestracji nowego użytkownika
    }

    private boolean isValidUser(String username, String password) {
        // Sprawdzenie czy użytkownik o podanym loginie i haśle istnieje w systemie
        // W tym przykładzie zwrócimy zawsze false, ale w prawdziwym systemie należy sprawdzić w bazie danych lub innej strukturze
        return false;
    }
}
