package com.test.migration.request;

import com.test.migration.model.Bank;
import com.test.migration.model.Client;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class AccountRequest {

    private Integer id;
    @NotBlank(message = "O número da conta não deve ser nulo!")
    private Integer number;
    private BigDecimal balance;
    private Client client;
    private Bank bank;

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public Bank getBank() {
        return bank;
    }
}
