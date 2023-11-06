package com.coders.Repository;

import com.coders.Domain.IdGenerator;
import com.coders.Domain.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class ProductRepository {

    static HashMap<Integer, Product> idsProduct = new HashMap<>();
    static IdGenerator idGenerator = new IdGenerator();

    public static Product addProduct() {

        Product product = new Product();
        idsProduct.put(idGenerator.GenerateId(),product);
        return product;
    }

    public static Product getProduct(){
        Product product = new Product();
        Integer Integer = null;
        idsProduct.get(idGenerator);// tu nie jestem pewna czy ma pobierać po idGenerator?
        return product;
    }

    public HashMap<Integer,Product> getAllProducts(){
        return idsProduct;}

    public static void removeProduct(){
        idsProduct.remove(idGenerator);
    }
}