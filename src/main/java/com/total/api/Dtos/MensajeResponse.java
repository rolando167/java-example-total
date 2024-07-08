package com.total.api.Dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensajeResponse implements Serializable{
    private String mensaje;
    private Object object;
}
