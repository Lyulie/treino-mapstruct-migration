package com.test.migration.controller;

import com.test.migration.model.Financing;
import com.test.migration.request.FinancingRequest;
import com.test.migration.service.FinancingService;
import com.test.migration.shared.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FinancingController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FinancingService financingService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody FinancingRequest dto) {

        Financing financing = modelMapper.financingRequestToModel(dto);
//        financingService.create(financing);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
