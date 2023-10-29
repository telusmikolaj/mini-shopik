package com.coders.repository;

import com.coders.domain.Product;
import com.coders.exceptions.InvalidTypeOfDataException;
import com.coders.exceptions.NoDataException;
import com.coders.exceptions.NotSuchElementException;
import com.coders.exceptions.TheSameNameException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.err;

public final class ProductRepository {

    private static ProductRepository INSTANCE;
    private Map<Integer, Product> productMap;
    private AtomicInteger idGenerator;

    private ProductRepository() {
        productMap = new HashMap<>();
        idGenerator = new AtomicInteger(1);
    }

    public static ProductRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductRepository();
        }

        return INSTANCE;
    }

    public Product addProduct(Product product) throws TheSameNameException, NoDataException, InvalidTypeOfDataException {
        try {
            if (product.getName() == null || product.getName().isEmpty()) {
                throw new NoDataException("Product name is missing or empty.");
            }
            if (!(product.getName() instanceof String)) {
                throw new InvalidTypeOfDataException("The name of the product should be a string ");
            }
            if (productMap.values().stream().anyMatch(prod -> prod.getName().equals(product.getName()))) {
                throw new TheSameNameException("Product with the same name already exists: " + product.getName());
            }

            int productId = idGenerator.getAndIncrement();
            product.setId(productId);
            productMap.put(product.getId(), product);
        } catch (NoDataException | TheSameNameException | InvalidTypeOfDataException e) {
            err.println(e.getMessage());
            throw e;
        }
        return product;
    }

    public Product getProductById(int id) throws NoDataException, NotSuchElementException {
        try {
            Product product = productMap.get(id);
            if (product == null) {
                throw new NotSuchElementException("Product with ID " + id + " not found.");
            }
            if (product.getName() == null || product.getName().isEmpty()) {
                throw new NoDataException("Product with ID " + id + " has no name.");
            }
            return product;
        } catch (NoDataException | NotSuchElementException e) {
            err.println(e.getMessage());
            throw e;
        }
    }

    public Product getProductByName(String name) throws NoDataException, NotSuchElementException {
        try {
            Product product = productMap.get(name);
            if (product == null) {
                throw new NotSuchElementException("Product with NAME " + name + " not found.");
            }
            if (product.getName() == null || product.getName().isEmpty()) {
                throw new NoDataException("Product with NAME " + name + " has no name.");
            }
            return product;
        } catch (NoDataException | NotSuchElementException e) {
            err.println(e.getMessage());
            throw e;
        }
    }

    public Map<Integer, Product> getAllProducts() throws NoDataException {
        if (productMap.isEmpty()) {
            throw new NoDataException("No products available.");
        }
        return productMap;
    }

    public void removeProductByName(String name) throws NotSuchElementException {
        Product product = productMap.get(name);
        if (product == null) {
            throw new NotSuchElementException("Product with NAME " + name + " not found.");
        } else {
            productMap.remove(name);
        }
    }

    public void removeAllProducts() throws NoDataException {
        productMap.clear();
    }
}
