package com.coders.repository;

import com.coders.domain.Product;
import com.coders.exceptions.InvalidTypeOfDataException;
import com.coders.exceptions.NoDataException;
import com.coders.exceptions.NotSuchElementException;
import com.coders.exceptions.TheSameNameException;
import com.coders.helpers.ProductValidator;

import java.util.HashMap;
import java.util.Map;
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
        try {
            productValidator.validate(product);
            if (productMap.values().stream().anyMatch(prod -> prod.getName().equals(product.getName()))) {
                throw new TheSameNameException("Product with the same name already exists: " + product.getName());
            }
            int productId = idGenerator.getAndIncrement();
            product.setId(productId);
            productMap.put(product.getId(), product);
            return product;
        } catch (NoDataException | NotSuchElementException | TheSameNameException | InvalidTypeOfDataException e) {
            throw e;
        }
    }

    public Product getProductById(int id) throws NoDataException, NotSuchElementException {
        try {
            Product product = productMap.get(id);
            productValidator.validate(product);
            return product;
        } catch (NoDataException | NotSuchElementException e) {
            throw e;
        }
    }

    public Map<Integer, Product> getAllProducts() throws NoDataException {
        if (productMap.isEmpty()) {
            throw new NoDataException("No products available.");
        }
        return productMap;
    }

    public Product removeProductByName(String name) throws NotSuchElementException {
        Product product = productMap.get(0);
        if (product == null) {
            throw new NotSuchElementException("Product with name " + name + " not found.");
        }
        productValidator.validate(product);
        productMap.remove(name);
        return product;
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
}
