package com.tutorial.apidemo.springBoot.tutorial.database;

import com.tutorial.apidemo.springBoot.tutorial.models.Product;
import com.tutorial.apidemo.springBoot.tutorial.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // Create a list to store products temporarily
              //  List<Product> productList = new ArrayList<>();

                // Add products to the list
                Product productA = new Product("Macboot",2025,520.00,"htps://localhost/v1");
                Product productB = new Product("Window",2024,520.00,"htps://localhost/v1");
                logger.info("Insert data"+productRepository.save(productA));//save dùng để lưu dữ liệu xuống data
                logger.info("Insert data"+productRepository.save(productB));
                // Print information about each product
//                for (Product product : productList) {
//                    logger.info("Product name: " + product.getProductName());
//                    logger.info("Year: " + product.getProductYear());
//                    logger.info("Price: " + product.getPrice());
//                    logger.info("URL: " + product.getUrl());
//                }
            }
        };
    }
}
