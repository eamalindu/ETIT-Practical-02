package com.hotel.customerservice.repository;

import com.hotel.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query(value = "{ '_id' : ?0 }")
    Customer getBYID(String customerID);
}
