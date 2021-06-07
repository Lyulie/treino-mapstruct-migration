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

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Bank bank;

    public Account() {}

    public Account(Integer number) {
        this.id = null;
        this.number = number;
        this.balance = null;
        this.client = null;
        this.bank = null;
    }

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
