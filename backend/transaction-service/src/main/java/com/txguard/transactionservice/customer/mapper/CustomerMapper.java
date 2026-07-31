package com.txguard.transactionservice.customer.mapper;

import com.txguard.transactionservice.customer.dto.CustomerRequest;
import com.txguard.transactionservice.customer.dto.CustomerResponse;
import com.txguard.transactionservice.customer.entity.Customer;
import com.txguard.transactionservice.customer.enums.AccountStatus;
import com.txguard.transactionservice.customer.enums.KycStatus;
import com.txguard.transactionservice.customer.enums.RiskLevel;

public class CustomerMapper {

    public static Customer toEntity(CustomerRequest request) {

        Customer customer = new Customer();

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setUpiId(request.getUpiId());

        customer.setAccountStatus(AccountStatus.ACTIVE);
        customer.setKycStatus(KycStatus.PENDING);
        customer.setRiskLevel(RiskLevel.LOW);

        return customer;
    }

    public static CustomerResponse toResponse(Customer customer) {

        CustomerResponse response = new CustomerResponse();

        response.setId(customer.getId());
        response.setFullName(customer.getFullName());
        response.setEmail(customer.getEmail());
        response.setMobileNumber(customer.getMobileNumber());
        response.setUpiId(customer.getUpiId());
        response.setAccountStatus(customer.getAccountStatus());
        response.setKycStatus(customer.getKycStatus());
        response.setRiskLevel(customer.getRiskLevel());

        return response;
    }
}