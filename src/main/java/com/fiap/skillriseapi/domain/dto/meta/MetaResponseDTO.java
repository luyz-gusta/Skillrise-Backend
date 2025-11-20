package com.fiap.skillriseapi.domain.dto.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaResponseDTO {
    private Long metaId;
    private Long userId;
    private String titulo;
    private String descricao;
    private String tipo;
    private Integer targetValue;
    private Integer currentValue;
    private String unidade;
    private Double progresso; // Percentual calculado
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDate prazo;
    private String status;
}
