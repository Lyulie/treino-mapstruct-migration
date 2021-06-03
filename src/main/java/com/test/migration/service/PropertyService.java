package com.test.migration.service;

import com.test.migration.model.Property;
import com.test.migration.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PropertyService {

    private static final String PROPERTY_NOT_FOUND_MSG = "Imóvel não encontrado";

    @Autowired
    private PropertyRepository propertyRepository;

    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    public Property findOne(Integer id) {
        return propertyRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, PROPERTY_NOT_FOUND_MSG
                ));
    }

//    public Property update(Integer id, Property property) {
//
//        Property propertyTemporary = findOne(id);
//        return propertyRepository.save(propertyTemporary);
//    }
}
