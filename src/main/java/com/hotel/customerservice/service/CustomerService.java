package com.hotel.customerservice.service;

import com.hotel.customerservice.dto.CustomerRequest;
import com.hotel.customerservice.dto.CustomerResponse;
import com.hotel.customerservice.model.Customer;
import com.hotel.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerResponse create(CustomerRequest customerRequest){

        System.out.println("Room Object from Service "+customerRequest);
        Customer cs = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .city(customerRequest.getCity())
                .build();

        System.out.println(cs);

        customerRepository.save(cs);

        CustomerResponse customerResponse = CustomerResponse.builder()
                .firstName(cs.getFirstName())
                .lastName(cs.getLastName())
                .city(cs.getCity())
                .build();

        return customerResponse;

    }
}
