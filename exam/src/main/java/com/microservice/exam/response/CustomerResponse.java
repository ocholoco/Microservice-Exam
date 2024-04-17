package com.microservice.exam.response;

public class CustomerResponse {

    private Long customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(int transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public void setTransactionStatusDescription(String transactionStatusDescription) {
        this.transactionStatusDescription = transactionStatusDescription;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customerNumber=" + customerNumber +
                ", transactionStatusCode=" + transactionStatusCode +
                ", transactionStatusDescription='" + transactionStatusDescription + '\'' +
                '}';
    }
}

