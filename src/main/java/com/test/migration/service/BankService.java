package com.test.migration.service;

import com.test.migration.model.Bank;
import com.test.migration.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class BankService {

    private static final String BANK_NOT_FOUND_MSG = "Banco não encontrado";

    @Autowired
    private BankRepository bankRepository;

    public Bank findOne(Integer id) {
        return bankRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, BANK_NOT_FOUND_MSG
                ));
    }

    public Bank findByCode(Integer code) {
        return bankRepository
                .findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, BANK_NOT_FOUND_MSG
                ));
    }

    public BigDecimal getTotalBalance(Integer id) {
        Bank bank = findOne(id);
        BigDecimal totalBalance = BigDecimal.ZERO;
        bank.getAccounts().forEach(acc -> totalBalance.add(acc.getBalance()));
        return totalBalance;
    }
}
