package com.total.api.Dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data  //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@Builder
public class ExampleCreateDto implements Serializable {
    private String name;
    private String last_name;
    private Integer status;
    private Double salary;
    private boolean published;
}