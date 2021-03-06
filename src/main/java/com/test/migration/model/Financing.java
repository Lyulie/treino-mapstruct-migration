package com.test.migration.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Financing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Client client;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Property property;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Bank bank;
    private BigDecimal financingValue;
    private Integer contributionsAmount;

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Property getProperty() {
        return property;
    }

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getFinancingValue() {
        return financingValue;
    }

    public Integer getContributionsAmount() {
        return contributionsAmount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setFinancingValue(BigDecimal financingValue) {
        this.financingValue = financingValue;
    }

    public void setContributionsAmount(Integer contributionsAmount) {
        this.contributionsAmount = contributionsAmount;
    }
}
