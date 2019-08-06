package com.oopsmails.springangularauth.repositories;

import com.oopsmails.springangularauth.models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, String> {
	
	@Override
    void delete(Products deleted);
}