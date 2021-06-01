package com.test.migration.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "bank")
    private List<Account> accounts;
}
