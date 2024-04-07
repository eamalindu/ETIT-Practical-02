package com.hotel.customerservice.repository;

import com.hotel.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
