package com.tutorial.apidemo.springBoot.tutorial.controller;


import com.tutorial.apidemo.springBoot.tutorial.models.Product;
import com.tutorial.apidemo.springBoot.tutorial.models.ResponseObject;
import com.tutorial.apidemo.springBoot.tutorial.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/insert")//ResponseObject đóng gói dữ liệut theo chuẩn,ResponseEntity được sử dụng để đóng gói phản hồi HTTP,
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke","insert Product successfuly",repository.save(newProduct))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct,@PathVariable Long id){
        Product updateProduct = repository.findById(id)
                .map(product ->{
                    product.setProductName(newProduct.getProductName());
                    product.setProductYear(newProduct.getProductYear());
                    product.setPrice(newProduct.getPrice());
                    product.setUrl(newProduct.getUrl());
                    //nếu sau khi map qua mà trùng dữ liệu thì update hết lại và save
                    return repository.save(product);
                }).orElseGet(() ->{//nếu nhu truyen vao k trung id thì tạo id mới
                    newProduct.setId(id);
                    return repository.save(new Product());

                });
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("status","succressfuly",updateProduct)) ;
    }



}
