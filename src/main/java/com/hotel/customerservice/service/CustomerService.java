package com.hotel.customerservice.service;

import com.hotel.customerservice.dto.CustomerRequest;
import com.hotel.customerservice.dto.CustomerResponse;
import com.hotel.customerservice.model.Customer;
import com.hotel.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Customer savedCustomer=  customerRepository.save(cs);

        CustomerResponse customerResponse = CustomerResponse.builder()
                .id(savedCustomer.getId())
                .firstName(savedCustomer.getFirstName())
                .lastName(savedCustomer.getLastName())
                .city(savedCustomer.getCity())
                .build();

        return customerResponse;

    }

    public List<CustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses=customers.stream().map(customer -> getCustomerResponse(customer)).toList();
        return customerResponses;
    }

    private CustomerResponse getCustomerResponse(Customer customer) {
        return
        CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .city(customer.getCity())
                .build();
    }

    public CustomerResponse findByID(String customerID) {

        Optional<Customer> optCustomer = Optional.ofNullable(customerRepository.getBYID(customerID));

        if (optCustomer.isPresent()) {
            Customer customer = optCustomer.get();
            return CustomerResponse.builder()
                    .id(customer.getId())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .city(customer.getCity())
                    .build();
        }
        else{
            return null;
        }
    }

}
