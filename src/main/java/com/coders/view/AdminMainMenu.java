package com.coders.view;

public class AdminMainMenu extends Menu {


    @Override
    public void display() {
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("=== MENU ADMINISTRATORA ===");
            System.out.println("1. Wyświetl dostępne produkty");
            System.out.println("2. Dodaj nowy produkt");
            System.out.println("3. Edytuj produkt");
            System.out.println("4. Usuń produkt");
            System.out.println("5. Przeglądaj zamówienia");
            System.out.println("6. Zarządzaj kontami użytkowników");
            System.out.println("7. Wyloguj");

            System.out.print("Wybierz opcję: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    viewOrders();
                    break;
                case 6:
                    manageUserAccounts();
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
//        ProductRepository productRepository = ProductRepository.getInstance();
//        Map<Integer, Product> products = productRepository.getAllProducts();
//
//        if (products.isEmpty()) {
//            System.out.println("Brak dostępnych produktów.");
//        } else {
//            System.out.println("Dostępne produkty:");
//            for (Map.Entry<Integer, Product> entry : products.entrySet()) {
//                Product product = entry.getValue();
//                System.out.println(product);
//            }
//        }
    }

    private void addProduct() {
        // 1. pobierz od admin dane produkt
        // 2. zapisz  produkt przez ProductService
    }

    private void editProduct() {
        // 1. wywietl liste produktow
        // 2. pobierz od admin id produktu
        // 3. pobierz dane do edycji
        // 4. zapisz zmieniony Produkt
    }

    private void deleteProduct() {
        // 1. wywietl liste produktow
        // 2. pobierz od admin id produktu
        // 3. usun produkt przez ProductService

    }

    private void viewOrders() {
        // opcjonalnie
    }

    private void manageUserAccounts() {

        // opcjonalnie
    }
}
