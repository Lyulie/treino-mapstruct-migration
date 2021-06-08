package com.test.migration.request;

import com.test.migration.model.Account;

import java.util.List;

public class BankRequest {

    private String name;
    private Integer code;
    private List<Account> accounts;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
