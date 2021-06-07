package com.test.migration.request;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AccountRequest {

    private Integer id;
    @NotNull(message = "O número da conta não deve ser nulo!")
    private Integer number;
    private BigDecimal balance;
    private String clientCpf;
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

    public String getClientCpf() {
        return clientCpf;
    }

    public Integer getBankCode() {
        return bankCode;
    }
}
