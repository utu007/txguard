package com.txguard.transactionservice.customer.service;

import com.txguard.transactionservice.customer.dto.CustomerRequest;
import com.txguard.transactionservice.customer.dto.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest request);

    CustomerResponse getCustomerById(UUID id);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse updateCustomer(UUID id, CustomerRequest request);

    void deleteCustomer(UUID id);
}