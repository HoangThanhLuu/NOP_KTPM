package com.tutorial.apidemo.springBoot.tutorial.controller;


import com.tutorial.apidemo.springBoot.tutorial.models.Product;
import com.tutorial.apidemo.springBoot.tutorial.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/product") //router
public class ProductController {
    @Autowired// đối tượng ProductRepository(lấy dữ liệu từ data) sẽ được tạo ra ngay khi cái cái app chạy và tạo ra một lần và sử dụng
    private ProductRepository repository;


    @GetMapping("/v2")
    List<Product> getAllProducts(){
        return repository.findAll();
    }
}
