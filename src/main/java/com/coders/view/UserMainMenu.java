package com.coders.view;

import com.coders.domain.Cart;
import com.coders.domain.Product;
import com.coders.repository.ProductRepository;
import com.coders.service.CartService;
import com.coders.service.ProductService;

import java.util.List;
import java.util.Map;

public class UserMainMenu extends Menu {
    private final Cart cart;
    private final CartService cartService;
    private List<Product> productList;

    public UserMainMenu(Cart cart) {
        this.cart = cart;
        this.cartService = new CartService(cart);
    }

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
        ProductRepository productRepository = ProductRepository.getInstance();
        ProductService productService = new ProductService(productRepository);
        Map<Integer, Product> allProducts = productService.getAllProducts();

        if (allProducts.isEmpty()) {
            System.out.println("Brak dostępnych produktów.");
        } else {
            System.out.println("Dostępne produkty:");
            for (Map.Entry<Integer, Product> entry : allProducts.entrySet()) {
                Product product = entry.getValue();
                System.out.println(product);
            }
        }
    }

    private void addToCart() {
//        System.out.print("Podaj ID produktu: ");
//        int productId = scanner.nextInt();
//        System.out.print("Podaj ilość: ");
//        int quantity = scanner.nextInt();
//        cartService.addToCart(productId, quantity);
//        System.out.println("Produkt został dodany do koszyka.");
        // TODO

        // 1. Dodawanie do koszyka poprzez CartService
    }

    private String viewCart() {
        String cartContent = cartService.viewCart(productList);
        System.out.println(cartContent);
        return cartContent;
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

