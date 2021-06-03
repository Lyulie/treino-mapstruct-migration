package com.test.migration.request;

import com.test.migration.model.Account;

import javax.validation.Valid;
import java.math.BigDecimal;

public class TransferValueRequest {

    @Valid
    private AccountRequest senderAccount;
    @Valid
    private AccountRequest receiverAccount;
    private BigDecimal valueToTransfer;

    public AccountRequest getSenderAccount() {
        return senderAccount;
    }

    public AccountRequest getReceiverAccount() {
        return receiverAccount;
    }

    public BigDecimal getValueToTransfer() {
        return valueToTransfer;
    }
}
