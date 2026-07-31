package com.txguard.transactionservice.customer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    private String fullName;

    private String email;

    private String mobileNumber;

    private String upiId;
}