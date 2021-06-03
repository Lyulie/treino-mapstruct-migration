package com.test.migration.request;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PropertyRequest {

    private Integer id;
    @Size(
            min = 3, max = 255,
            message = "O campo não deve ser nulo, e deve ter entre 3 e 255 caracteres"
    )
    private String type;

    @NotNull(message = "O valor não deve ser nulo!")
    @Min(value = 1000L, message = "O valor deve ser de 1000 reais ou superior")
    private BigDecimal value;

    @NotBlank(message = "O código não deve ser nulo!")
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
