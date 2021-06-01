package com.test.migration.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cpf;
    private BigDecimal salary;
    @OneToMany(mappedBy = "client")
    private List<Financing> financings;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public List<Financing> getFinancings() {
        return financings;
    }
}
