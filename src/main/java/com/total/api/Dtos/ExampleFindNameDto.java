package com.total.api.Dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExampleFindNameDto implements Serializable {
    private String name;
    private String last_name;
    private String email;
    private Double salary;
}
