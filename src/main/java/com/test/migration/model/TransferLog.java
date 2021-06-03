package com.test.migration.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
public class TransferLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Account senderAccount;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Account receiverAccount;
    private BigDecimal transferredValue;
    private final Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());

    public Integer getId() {
        return id;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public BigDecimal getTransferredValue() {
        return transferredValue;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
