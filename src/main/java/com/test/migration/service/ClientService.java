package com.test.migration.service;

import com.test.migration.model.Client;
import com.test.migration.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class ClientService {

    private static final String CLIENT_NOT_FOUND_MSG = "O Cliente não foi encontrado.";

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Client findOne(Integer id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, CLIENT_NOT_FOUND_MSG
                ));
    }

    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public BigDecimal getTotalFinancings(Integer id) {

        Client client = findOne(id);

        BigDecimal totalFinancings = BigDecimal.ZERO;
        client.getFinancings().forEach(f -> totalFinancings.add(f.getFinancingValue()));

        return totalFinancings;
    }
}
