package com.test.migration.controller;

import com.test.migration.model.Property;
import com.test.migration.request.PropertyRequest;
import com.test.migration.service.PropertyService;
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
@RequestMapping("properties")
public class PropertyController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Property> create(@Valid @RequestBody PropertyRequest dto) {

        Property property = modelMapper.propertyRequestToModel(dto);
        propertyService.create(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(property);
    }
}
