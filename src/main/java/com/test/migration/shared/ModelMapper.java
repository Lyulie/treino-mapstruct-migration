package com.test.migration.shared;

import com.test.migration.model.*;
import com.test.migration.request.AccountRequest;
import com.test.migration.request.ClientRequest;
import com.test.migration.request.PropertyRequest;
import com.test.migration.request.TransferValueRequest;
import com.test.migration.response.ClientResponse;
import com.test.migration.response.TransferLogResponse;
import org.mapstruct.*;

import javax.persistence.Embedded;
import java.util.ArrayList;

@Mapper(componentModel = "spring", imports = {Account.class, Financing.class, ArrayList.class})
public interface ModelMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Property propertyRequestToModel(PropertyRequest propertyRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(
                    target = "senderAccount",
                    expression = "java(new Account(transferValueRequest.getSenderAccountNumber()))"
            ),
            @Mapping(
                    target = "receiverAccount",
                    expression = "java(new Account(transferValueRequest.getReceiverAccountNumber()))"
            ),
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "transferValueRequest.valueToTransfer", target = "transferredValue")
    })
    TransferLog transferRequestToModel(TransferValueRequest transferValueRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(source = "transferLog.senderAccount.client.name", target = "senderName"),
            @Mapping(source = "transferLog.receiverAccount.client.name", target = "receiverName")
    })
    TransferLogResponse transferLogToResponse(TransferLog transferLog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account accountRequestToModel(AccountRequest accountRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(source = "clientRequest.name", target = "name"),
            @Mapping(target = "financings", defaultExpression = "java(new ArrayList<Financing>())")
    })
    Client clientRequestToModel(ClientRequest clientRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ClientResponse clientToResponse(Client client);
}
