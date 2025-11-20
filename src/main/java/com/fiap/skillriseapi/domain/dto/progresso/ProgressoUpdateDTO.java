package com.fiap.skillriseapi.domain.dto.progresso;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgressoUpdateDTO {

    @NotNull(message = "Porcentagem é obrigatória")
    @DecimalMin(value = "0.0", message = "Porcentagem deve ser no mínimo 0")
    @DecimalMax(value = "100.0", message = "Porcentagem deve ser no máximo 100")
    private BigDecimal percentage;
}
