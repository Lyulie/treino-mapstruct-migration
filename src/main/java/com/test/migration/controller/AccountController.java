package com.test.migration.controller;

import com.test.migration.model.Account;
import com.test.migration.model.TransferLog;
import com.test.migration.request.AccountRequest;
import com.test.migration.request.TransferValueRequest;
import com.test.migration.response.AccountResponse;
import com.test.migration.response.TransferLogResponse;
import com.test.migration.service.AccountService;
import com.test.migration.shared.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountRequest dto) {

        Account account = modelMapper.accountRequestToModel(dto);
        accountService.create(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping("transfer")
    public ResponseEntity<TransferLogResponse> transfer(@Valid @RequestBody TransferValueRequest dto) {

        TransferLog transferLog = modelMapper.transferRequestToModel(dto);
        accountService.moneyTransfer(transferLog);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
