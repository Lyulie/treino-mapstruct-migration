package com.test.migration.service;

import com.test.migration.model.Financing;
import com.test.migration.repository.FinancingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class FinancingService {

    private static final String FINANCING_NOT_FOUND_MSG = "O financiamento não foi encontrado";

    @Autowired
    private FinancingRepository financingRepository;

    public Financing findOne(Integer id) {

        return financingRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, FINANCING_NOT_FOUND_MSG
                ));
    }

    public Financing receiveContribution(Integer id, BigDecimal value) {

        Financing financing = findOne(id);
        financing.setFinancingValue(financing.getFinancingValue().subtract(value));
        financing.setContributionsAmount(financing.getContributionsAmount() + 1);

        return financingRepository.save(financing);
    }
}
