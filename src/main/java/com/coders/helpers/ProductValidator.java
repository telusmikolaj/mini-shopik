package com.coders.helpers;

import com.coders.domain.Product;
import com.coders.exceptions.InvalidTypeOfDataException;
import com.coders.exceptions.NoDataException;
import com.coders.exceptions.NotSuchElementException;
import com.coders.exceptions.TheSameNameException;

import java.util.HashMap;
import java.util.Map;

public class ProductValidator implements ProductValidatorInterface<Product> {
    private Map<Integer, Product> productMap = new HashMap<>();
    public void validate(Product product) throws NoDataException, TheSameNameException, InvalidTypeOfDataException, NotSuchElementException {
        if (product == null) {
            throw new NotSuchElementException("Product doesn't exist");
        }

        if (product.getName() == null || product.getName().isEmpty()) {
            throw new NoDataException("Product name is missing or empty.");
        }

        if (!(product.getName() instanceof String)) {
            throw new InvalidTypeOfDataException("The name of the product should be a string.");
        }

        if (productMap.values().stream().anyMatch(prod -> prod.getName().equals(product.getName()))) {
            throw new TheSameNameException("Product with the same name already exists: " + product.getName());
        }
    }
}
