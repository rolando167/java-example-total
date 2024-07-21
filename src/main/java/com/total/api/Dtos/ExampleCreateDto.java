package com.total.api.Dtos;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
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
    @NotNull(message = "Name may not be null") // -> null
    @NotEmpty(message = "Name may not be empty")// -> ""
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @NotBlank(message = "Name may not be blank") // -> " "
    private String name;

    @NotBlank(message = "last_name may not be null")
    private String last_name;

    @Email
    @NotBlank(message = "Email may not be null")
    private String email;

    private Integer status;

    private Double salary;

    private boolean published;
}