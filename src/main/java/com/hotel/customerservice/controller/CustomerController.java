package com.hotel.customerservice.controller;

import com.hotel.customerservice.dto.CustomerRequest;
import com.hotel.customerservice.dto.CustomerResponse;
import com.hotel.customerservice.model.Customer;
import com.hotel.customerservice.repository.CustomerRepository;
import com.hotel.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CustomerRequest customerRequest){
//        System.out.println("Room Service");
//        System.out.println(roomRequest);

        CustomerResponse customerResponse = customerService.create(customerRequest);
        return customerResponse;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll(){
       return customerService.getAll();
    }
}
