package com.test.migration.shared;

import com.test.migration.model.Account;
import com.test.migration.model.Property;
import com.test.migration.model.TransferLog;
import com.test.migration.request.AccountRequest;
import com.test.migration.request.PropertyRequest;
import com.test.migration.request.TransferValueRequest;
import com.test.migration.response.TransferLogResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Property propertyRequestToModel(PropertyRequest propertyRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TransferLog transferRequestToModel(TransferValueRequest transferValueRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(source = "transferLog.senderAccount.client.name", target = "senderName"),
            @Mapping(source = "transferLog.receiverAccount.client.name", target = "receiverName")
    })
    TransferLogResponse transferLogToResponse(TransferLog transferLog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account accountRequestToModel(AccountRequest accountRequest);
}
