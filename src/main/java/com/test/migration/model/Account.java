package com.test.migration.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer number;
    private BigDecimal balance;

    @PrimaryKeyJoinColumn
    private Client client;

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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
