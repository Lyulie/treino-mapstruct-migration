package com.test.migration.shared;

import com.test.migration.model.Property;
import com.test.migration.request.PropertyRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Property propertyRequestToModel(PropertyRequest propertyRequest);
}
