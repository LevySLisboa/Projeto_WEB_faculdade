package com.project.API_WEB.repository;

import com.project.API_WEB.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Product,String> {}
