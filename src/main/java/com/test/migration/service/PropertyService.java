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
    private static final String DUPLICATED_PROPERTY_MSG = "Já existe um imóvel com este código registrado";

    @Autowired
    private PropertyRepository propertyRepository;

    public Property create(Property property) {
        validateCreate(property);
        return propertyRepository.save(property);
    }

    public Property findOne(Integer id) {
        return propertyRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, PROPERTY_NOT_FOUND_MSG
                ));
    }

    private Property findByCode(String code) {
        return propertyRepository.findByCode(code);
    }

    private void validateCreate(Property property) {

        if(findByCode(property.getCode()) == null) return;

        throw new ResponseStatusException(
                HttpStatus.UNPROCESSABLE_ENTITY, DUPLICATED_PROPERTY_MSG
        );
    }
//    public Property update(Integer id, Property property) {
//
//        Property propertyTemporary = findOne(id);
//        return propertyRepository.save(propertyTemporary);
//    }
}
