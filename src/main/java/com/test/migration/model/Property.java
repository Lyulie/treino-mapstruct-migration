package com.test.migration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private BigDecimal value;
    private Integer code;

    @Deprecated
    public Property(){}

    public Property(Integer id, String type, BigDecimal value, Integer code) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.code = code;
    }

    public Property(Integer code) {
        this(null, null, null, code);
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
