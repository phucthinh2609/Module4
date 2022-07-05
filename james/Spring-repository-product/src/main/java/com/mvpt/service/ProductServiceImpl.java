package com.mvpt.service;

import com.mvpt.model.Product;
import com.mvpt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }
}
