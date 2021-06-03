package com.test.migration.response;

import java.math.BigDecimal;

public class TransferLogResponse {

    private Integer id;
    private String senderName;
    private String receiverName;
    private BigDecimal transferredValue;

    public Integer getId() {
        return id;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public BigDecimal getTransferredValue() {
        return transferredValue;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setTransferredValue(BigDecimal transferredValue) {
        this.transferredValue = transferredValue;
    }
}
