package com.fiap.skillriseapi.domain.dto.modulo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuloResponseDTO {
    private Long moduloId;
    private String title;
    private Integer durationMinutes;
    private String contentType;
    private LocalDate createdAt;
}
