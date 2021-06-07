package com.test.migration.request;

import com.test.migration.model.Financing;

import java.math.BigDecimal;
import java.util.List;

public class ClientRequest {

    private Integer id;
    private String name;
    private String cpf;
    private BigDecimal salary;
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
