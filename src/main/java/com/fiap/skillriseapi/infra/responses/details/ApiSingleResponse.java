package com.fiap.skillriseapi.infra.responses.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiSingleResponse<T> {
    private Integer status;
    private String message;
    private T data;
}
