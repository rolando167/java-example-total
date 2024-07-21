package com.total.api.Dtos;

import java.io.Serializable;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleCreateDto implements Serializable {
    @NotNull(message = "Name may not be null") // not -> null
    @NotEmpty(message = "Name may not be empty") // not -> ""
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @NotBlank(message = "Name may not be blank") // not -> " " & null
    private String name;

    @NotBlank(message = "last_name may not be null")
    private String last_name;

    @Email
    @NotBlank(message = "Email may not be null")
    private String email;

    @Min(value = 1)
    @Max(value = 5)
    // @PositiveOrZero
    // @Positive
    // @NegativeOrZero
    // @Negative
    private Integer status;

    @DecimalMin(value = "0.1", message = "El salario no puede ser menor a 0")
    @DecimalMax(value = "9999.99")
    private Double salary;

    private boolean published;
}