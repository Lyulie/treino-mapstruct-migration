package com.test.migration.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PropertyRequest {

    private Integer id;
    @Size(
            min = 3, max = 255,
            message = "O campo não deve ser nulo, e deve ter entre 3 e 255 caracteres"
    )
    private String type;

    @NotNull(message = "O campo não deve ser nulo!")
    @Min(value = 1000L, message = "a")
    private BigDecimal value;

    @NotNull(message = "O campo não deve ser nulo!")
    private String code;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }
}
