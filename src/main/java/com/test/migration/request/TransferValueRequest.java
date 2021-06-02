package com.test.migration.request;

import java.math.BigDecimal;

public class TransferValueRequest {

    private Integer senderAccount;
    private Integer receiverAccount;
    private BigDecimal valueToTransfer;

    public Integer getSenderAccount() {
        return senderAccount;
    }

    public Integer getReceiverAccount() {
        return receiverAccount;
    }

    public BigDecimal getValueToTransfer() {
        return valueToTransfer;
    }
}
