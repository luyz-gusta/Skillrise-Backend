package com.fiap.skillriseapi.infra.responses.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiMessageResponse {
    private Integer status;
    private String message;
}
