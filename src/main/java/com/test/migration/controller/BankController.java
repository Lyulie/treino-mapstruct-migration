package com.test.migration.controller;

import com.test.migration.model.Bank;
import com.test.migration.request.BankRequest;
import com.test.migration.service.BankService;
import com.test.migration.shared.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("banks")
public class BankController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BankService bankService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BankRequest dto) {

        Bank bank = modelMapper.bankRequestToModel(dto);
        bankService.create(bank);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping
    public ResponseEntity<List<Bank>> searchCriteria() {

        // TODO: Fazer pageable com dto
        return ResponseEntity.status(HttpStatus.OK).body(bankService.findAll());
    }

}
