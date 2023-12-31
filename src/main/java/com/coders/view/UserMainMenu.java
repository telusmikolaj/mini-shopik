package com.coders.view;

public class UserMainMenu extends Menu {

    @Override
    public void display() {
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("=== MENU UŻYTKOWNIKA ===");
            System.out.println("1. Wyświetl dostępne produkty");
            System.out.println("2. Dodaj produkt do koszyka");
            System.out.println("3. Wyświetl zawartość koszyka");
            System.out.println("4. Usuń produkt z koszyka");
            System.out.println("5. Finalizacja zakupu");
            System.out.println("6. Doładowanie konta");
            System.out.println("7. Wyloguj");

            System.out.print("Wybierz opcję: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    removeFromCart();
                    break;
                case 5:
                    finalizePurchase();
                    break;
                case 6:
                    topUpAccount();
                    break;
                case 7:
                    System.out.println("Wylogowano pomyślnie.");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Nieznana opcja! Spróbuj ponownie.");
                    break;
            }
        }
    }

    private void displayProducts() {
        // TODO
        // 1. Pobieranie produktow z ProductService
        // 2. wyświetlenie dostępnych produktów
    }

    private void addToCart() {
        // TODO

        // 1. Dodawanie do koszyka poprzez CartService
    }

    private void viewCart() {
        // TODO

        // 1. wyświetlenie zawartości koszyka CartService
    }

    private void removeFromCart() {
        // TODO

        // 2. usuwanie produktu z koszyka CartService
    }

    private void finalizePurchase() {
    }

    private void topUpAccount() {

    }
}