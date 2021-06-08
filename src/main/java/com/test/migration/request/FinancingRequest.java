package com.test.migration.request;

import java.math.BigDecimal;

public class FinancingRequest {

    private Integer id;
    private String clientCpf;
    private Integer propertyCode;
    private Integer bankCode;
    private BigDecimal financingValue;
    private Integer contributionsAmount;

    public Integer getId() {
        return id;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public Integer getPropertyCode() {
        return propertyCode;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public BigDecimal getFinancingValue() {
        return financingValue;
    }

    public Integer getContributionsAmount() {
        return contributionsAmount;
    }
}
