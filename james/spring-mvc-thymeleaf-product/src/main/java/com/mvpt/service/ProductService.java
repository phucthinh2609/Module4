package com.mvpt.service;

import com.mvpt.model.Product;

import java.util.*;

public class ProductService implements IProductService {
    private final static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Iphone 6", 10000000, 10, "Blue"));
        productList.put(2, new Product(2, "Samsung Galaxy", 21000000, 15, "Black"));
        productList.put(3, new Product(3, "Iphone X", 25000000, 21, "Gold"));
        productList.put(4, new Product(4, "Bphone 3", 12000000, 35, "White"));
        productList.put(5, new Product(5, "Oppo 5", 18000000, 32, "Blue"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = findAll();
        List<Product> results = new ArrayList<>();

        String search = name.toLowerCase();

        for (Product product : productList){
            if (product.getName().toLowerCase().equals(search)){
                results.add(product);
            }
        }
        return results;
    }
}
