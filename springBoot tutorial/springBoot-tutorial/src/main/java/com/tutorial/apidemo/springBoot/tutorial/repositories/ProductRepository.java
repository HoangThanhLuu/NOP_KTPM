package com.tutorial.apidemo.springBoot.tutorial.repositories;

import com.tutorial.apidemo.springBoot.tutorial.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//Spring sẽ tự động cung cấp các phương thức CRUD
public interface ProductRepository extends JpaRepository<Product,Long> {
}
