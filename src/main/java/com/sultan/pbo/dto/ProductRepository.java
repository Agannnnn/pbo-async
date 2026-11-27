package com.sultan.pbo.dto;

import java.util.ArrayList;
import java.util.HashMap;

import com.sultan.pbo.model.Product;

public class ProductRepository {
    private static final HashMap<String, Product> products = new HashMap<>();

    public void create(String no, String name, int qty, double price) throws Exception {
        if (products.containsKey(no)) {
            throw new Exception("product already exist.");
        }

        Product product = new Product(no, name, qty, price);
        products.put(no, product);
    }

    public Product find(String no) {
        Product product = products.get(no);
        if (product == null)
            return null;

        return product;
    }

    public ArrayList<Product> findAll() {
        return new ArrayList<Product>(products.values());
    }

    public void update(String no, String name, int qty, double price) throws Exception {
        if (!products.containsKey(no)) {
            throw new Exception("product does not exist.");
        }

        Product product = products.get(no);
        product.setName(name);
        product.setPrice(price);
        product.setQty(qty);
    }

    public void delete(String no) throws Exception {
        if (!products.containsKey(no)) {
            throw new Exception("product does not exist.");
        }

        products.remove(no);
    }
}
