package com.txguard.transactionservice.customer.service;


import com.txguard.transactionservice.customer.dto.CustomerRequest;
import com.txguard.transactionservice.customer.dto.CustomerResponse;
import com.txguard.transactionservice.customer.entity.Customer;
import com.txguard.transactionservice.customer.exception.DuplicateResourceException;
import com.txguard.transactionservice.customer.exception.ResourceNotFoundException;
import com.txguard.transactionservice.customer.mapper.CustomerMapper;
import com.txguard.transactionservice.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

@Override
public CustomerResponse createCustomer(CustomerRequest request) {

    if (customerRepository.existsByEmail(request.getEmail())) {
        throw new DuplicateResourceException("Email already exists");
    }

    if (customerRepository.existsByMobileNumber(request.getMobileNumber())) {
        throw new DuplicateResourceException("Mobile number already exists");
    }

    if (customerRepository.existsByUpiId(request.getUpiId())) {
        throw new DuplicateResourceException("UPI ID already exists");
    }

    Customer customer = CustomerMapper.toEntity(request);

    Customer savedCustomer = customerRepository.save(customer);

    return CustomerMapper.toResponse(savedCustomer);
}

@Override
public CustomerResponse getCustomerById(UUID id) {

    Customer customer = customerRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Customer not found"));

    return CustomerMapper.toResponse(customer);
}

@Override
public List<CustomerResponse> getAllCustomers() {

    return customerRepository.findAll()
            .stream()
            .map(CustomerMapper::toResponse)
            .toList();
}

@Override
public CustomerResponse updateCustomer(UUID id, CustomerRequest request) {

    Customer customer = customerRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Customer not found"));

    customer.setFullName(request.getFullName());
    customer.setEmail(request.getEmail());
    customer.setMobileNumber(request.getMobileNumber());
    customer.setUpiId(request.getUpiId());

    Customer updatedCustomer = customerRepository.save(customer);

    return CustomerMapper.toResponse(updatedCustomer);
}

@Override
public void deleteCustomer(UUID id) {

    Customer customer = customerRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Customer not found"));

    customerRepository.delete(customer);
}
}