package com.test.migration.response;

import java.math.BigDecimal;

public class AccountResponse {

    private Integer id;
    private Integer number;
    private BigDecimal balance;
    private String clientName;
    private Integer bankCode;

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }
}
