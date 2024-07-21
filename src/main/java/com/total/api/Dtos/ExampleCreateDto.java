package com.total.api.Dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data  //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleCreateDto implements Serializable {
    private String name;
    private String last_name;
    private String email;
    private Integer status;
    private Double salary;
    private boolean published;
}