package com.test.migration.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer code;

    @OneToMany(mappedBy = "bank")
    private List<Account> accounts;

    @Deprecated
    public Bank() {
    }

    public Bank(Integer id, String name, Integer code, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.accounts = accounts;
    }

    public Bank(Integer code) {
        this(null, null, code, null);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
