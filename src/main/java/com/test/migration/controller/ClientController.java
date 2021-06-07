package com.test.migration.controller;

import com.test.migration.model.Client;
import com.test.migration.request.ClientRequest;
import com.test.migration.response.ClientResponse;
import com.test.migration.service.ClientService;
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
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody ClientRequest dto) {

        Client client = modelMapper.clientRequestToModel(dto);
        clientService.create(client);

        ClientResponse clientResponse = modelMapper.clientToResponse(client);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientResponse);
    }
}
