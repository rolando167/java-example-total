package com.total.api.Dtos;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleCreateDto implements Serializable {
    @NotNull(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "last_name is mandatory")
    private String last_name;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    private Integer status;

    private Double salary;

    private boolean published;
}