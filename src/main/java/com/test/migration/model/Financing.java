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
    private Property property;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Bank bank;
    private BigDecimal financingValue;
    private Integer contributionsAmount;
}
