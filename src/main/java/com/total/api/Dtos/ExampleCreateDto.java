package com.total.api.Dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.AssertTrue;
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
    // @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
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

    @AssertTrue // || @AssertFalse
    private boolean published;

    // @Digits(integer = 1, fraction = 2, message = "The number received is invalid")
    // @NotNull(message = "height can't be null")
    // private double height;

    // @Past(message = "The date must be before the current date")
    // private LocalDate dateOfBirth;

    // @Future(message = "The date must be before the current date")
    // || @PastOrPresent || @FutureOrPresent
    // private LocalDate dateOfRenovation;

    // @CreditCardNumber
    // private Long phone;

    // @Valid
    // private DepartmentDTO departmentDTO;
}