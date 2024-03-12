package com.tutorial.apidemo.springBoot.tutorial.controller;


import com.tutorial.apidemo.springBoot.tutorial.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/product") //router
public class ProductController {

    @GetMapping("/v2")
    List<Product> getAllProduct(){
        return List.of();



    }
}
