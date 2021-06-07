package com.test.migration.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", initialValue = 3, allocationSize = 1)
    private Integer id;
    private String name;
    private String cpf;
    private BigDecimal salary;
    @OneToMany(mappedBy = "client")
    private List<Financing> financings = new ArrayList<>();

    @Deprecated
    public Client() {
    }

    public Client(Integer id, String name, String cpf, BigDecimal salary, List<Financing> financings) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
        this.financings = financings;
    }

    public Client(String cpf) {
        this(null, null, cpf, null, null);
    }

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setFinancings(List<Financing> financings) {
        this.financings = financings;
    }
}
