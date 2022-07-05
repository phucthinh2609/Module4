package com.mvpt;

import com.mvpt.repository.ProductRepository;
import com.mvpt.repository.ProductRepositoryImpl;
import com.mvpt.service.ProductService;
import com.mvpt.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }
}
