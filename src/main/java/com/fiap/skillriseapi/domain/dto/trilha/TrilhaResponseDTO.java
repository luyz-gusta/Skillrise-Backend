package com.fiap.skillriseapi.domain.dto.trilha;

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
public class TrilhaResponseDTO {
    private Long trilhaId;
    private String title;
    private String description;
    private String difficulty;
    private BigDecimal durationHours;
    private String imageUrl;
    private String tags;
    private BigDecimal rating;
    private Integer totalAvaliacoes;
    private String categoria;
    private LocalDate createdAt;
}
