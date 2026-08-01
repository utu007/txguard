CREATE TABLE customers
(
    id UUID PRIMARY KEY,

    full_name VARCHAR(100) NOT NULL,

    email VARCHAR(255) UNIQUE NOT NULL,

    mobile_number VARCHAR(10) UNIQUE NOT NULL,

    upi_id VARCHAR(100) UNIQUE NOT NULL,

    account_status VARCHAR(20) NOT NULL,

    kyc_status VARCHAR(20) NOT NULL,

    risk_level VARCHAR(20) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);