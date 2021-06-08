package com.test.migration.service;

import com.test.migration.model.Bank;
import com.test.migration.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankService {

    private static final String BANK_NOT_FOUND_MSG = "Banco não encontrado";
    private static final String BANK_ALREADY_REGISTERED_MSG = "Banco com este código já cadastrado";

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
        return bankRepository.findByCode(code);
    }

    public BigDecimal getTotalBalance(Integer id) {
        Bank bank = findOne(id);
        BigDecimal totalBalance = BigDecimal.ZERO;
        bank.getAccounts().forEach(acc -> totalBalance.add(acc.getBalance()));
        return totalBalance;
    }

    public Bank create(Bank bank) {
        if(bankRepository.findByCode(bank.getCode()) != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BANK_ALREADY_REGISTERED_MSG);

        return bankRepository.save(bank);
    }

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }
}
