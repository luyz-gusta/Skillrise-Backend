package com.fiap.skillriseapi.domain.dto.progresso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgressoResponseDTO {
    private Long progressoId;
    private Long inscricaoId;
    private Long moduloId;
    private String moduloTitle;
    private BigDecimal percentage;
    private LocalDate lastUpdated;
    private LocalDate completedAt;
}
