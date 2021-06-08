package com.test.migration.shared;

import com.test.migration.model.*;
import com.test.migration.request.*;
import com.test.migration.response.ClientResponse;
import com.test.migration.response.TransferLogResponse;
import org.mapstruct.*;

import javax.persistence.Embedded;
import java.util.ArrayList;

@Mapper(componentModel = "spring", imports = {
        Account.class, Financing.class, Bank.class, Client.class, ArrayList.class
})
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
    @Mappings({
            @Mapping(target = "client", expression = "java(new Client(accountRequest.getClientCpf()))"),
            @Mapping(target = "bank", expression = "java(new Bank(accountRequest.getBankCode()))")
    })
    Account accountRequestToModel(AccountRequest accountRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(source = "clientRequest.name", target = "name"),
            @Mapping(target = "financings", defaultExpression = "java(new ArrayList<Financing>())")
    })
    Client clientRequestToModel(ClientRequest clientRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ClientResponse clientToResponse(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(
                    target = "client",
                    expression = "java(new Client(financingRequest.getClientCpf()))"
            ),
            @Mapping(
                    target = "bank",
                    expression = "java(new Bank(financingRequest.getBankCode()))"
            ),
            @Mapping(
                    target = "property",
                    expression = "java(new Property(financingRequest.getPropertyCode()))"
            )
    })
    Financing financingRequestToModel(FinancingRequest financingRequest);
}
