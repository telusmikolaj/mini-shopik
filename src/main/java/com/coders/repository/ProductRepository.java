package com.coders.repository;

import com.coders.domain.Product;
import com.coders.exceptions.InvalidTypeOfDataException;
import com.coders.exceptions.NoDataException;
import com.coders.exceptions.NotSuchElementException;
import com.coders.exceptions.TheSameNameException;
import com.coders.helpers.ProductValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public final class ProductRepository {

    private static ProductRepository INSTANCE;
    private ProductValidator productValidator;
    private Map<Integer, Product> productMap;
    private AtomicInteger idGenerator;

    private ProductRepository() {
        productMap = new HashMap<>();
        idGenerator = new AtomicInteger(1);
        productValidator = new ProductValidator();
    }

    public static ProductRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductRepository();
        }
        return INSTANCE;
    }

    public Product addProduct(Product product) throws TheSameNameException, NoDataException, InvalidTypeOfDataException, NotSuchElementException {
        productValidator.validate(product);
        if (hasProductWithSameName(product)) {
            throw new TheSameNameException("Product with the same name already exists: " + product.getName());
        };
        int productId = idGenerator.getAndIncrement();
        product.setId(productId);
        productMap.put(product.getId(), product);
        return product;
    }

    public Product getProductById(int id) throws NoDataException, NotSuchElementException {
        return Optional.ofNullable(productMap.get(id))
                .orElseThrow(() -> new NoDataException("No product found with ID: " + id));
    }

    public Product getProductByName(String name) throws NoDataException, NotSuchElementException {
        Optional<Product> matchingProduct = productMap.values()
                .stream()
                .filter(product -> product.getName().equals(name))
                .findFirst();
        return matchingProduct.orElseThrow(() -> new NoDataException("No product found with NAME: " + name));
    }

    public Map<Integer, Product> getAllProducts() throws NoDataException {
        if (productMap.isEmpty()) {
            throw new NoDataException("No products available.");
        }
        return productMap;
    }

    public Product removeProductByName(String name) throws NotSuchElementException {
        Product product = getProductByName(name);

        if (product != null) {
            productMap.values().removeIf(p -> p.getId() == product.getId());
            return product;
        } else {
            throw new NotSuchElementException("No product found with name: " + name);
        }
    }

    public Product removeProductById(int id) throws NotSuchElementException {
        Product product = productMap.get(id);
        productValidator.validate(product);
        productMap.remove(id);
        return product;
    }

    public void removeAllProducts() throws NoDataException {
        productMap.clear();
    }

    private boolean hasProductWithSameName(Product product) {
        return productMap.values().stream()
                .map(Product::getName)
                .anyMatch(product.getName()::equals);
    }
}
