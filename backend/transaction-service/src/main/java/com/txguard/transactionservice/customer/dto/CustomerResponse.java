package com.txguard.transactionservice.customer.dto;

import com.txguard.transactionservice.customer.enums.AccountStatus;
import com.txguard.transactionservice.customer.enums.KycStatus;
import com.txguard.transactionservice.customer.enums.RiskLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerResponse {

    private UUID id;

    private String fullName;

    private String email;

    private String mobileNumber;

    private String upiId;

    private AccountStatus accountStatus;

    private KycStatus kycStatus;

    private RiskLevel riskLevel;
}