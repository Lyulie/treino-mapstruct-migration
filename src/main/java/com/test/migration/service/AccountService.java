package com.test.migration.service;

import com.test.migration.model.Account;
import com.test.migration.repository.AccountRepository;
import com.test.migration.request.TransferValueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private static final String ACCOUNT_NOT_FOUND_MSG = "A conta não foi encontrada";
    private static final String INSUFFICIENT_BALANCE_MSG = "Saldo insuficiente";

    @Autowired
    private AccountRepository accountRepository;

    public Account findOne(Integer id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, ACCOUNT_NOT_FOUND_MSG
                ));
    }

    public Account findByNumber(Integer number) {
        return accountRepository
                .findByNumber(number)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, ACCOUNT_NOT_FOUND_MSG
                ));
    }

    public Account depositValue(Integer number, BigDecimal value) {
        Account account = findByNumber(number);
        if(value.compareTo(BigDecimal.ZERO) > 0) {
            account.setBalance(account.getBalance().add(value));
            accountRepository.save(account);
        }
        return account;
    }

    public Account withdrawValue(Integer number, BigDecimal value) {
        Account account = findByNumber(number);
        if(value.compareTo(account.getBalance()) <= 0) {
            account.setBalance(account.getBalance().subtract(value));
            return accountRepository.save(account);
        }
        throw new ResponseStatusException(
                HttpStatus.UNPROCESSABLE_ENTITY,
                INSUFFICIENT_BALANCE_MSG
        );
    }

    public void moneyTransfer(TransferValueRequest transferValueRequest) {


    }
}
