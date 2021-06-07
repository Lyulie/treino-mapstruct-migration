package com.test.migration.request;

import com.test.migration.model.Account;

import javax.validation.Valid;
import java.math.BigDecimal;

public class TransferValueRequest {


    private Integer senderAccountNumber;

    private Integer receiverAccountNumber;

    private BigDecimal valueToTransfer;

    public Integer getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public Integer getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public BigDecimal getValueToTransfer() {
        return valueToTransfer;
    }
}
