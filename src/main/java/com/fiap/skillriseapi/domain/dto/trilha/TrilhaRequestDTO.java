package com.fiap.skillriseapi.domain.dto.trilha;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrilhaRequestDTO {

    @NotBlank(message = "Título da trilha é obrigatório")
    @Size(max = 300, message = "Título não pode exceder 300 caracteres")
    private String title;

    private String description;

    private String difficulty;

    private BigDecimal durationHours;

    @Size(max = 500, message = "URL da imagem não pode exceder 500 caracteres")
    private String imageUrl;

    @Size(max = 500, message = "Tags não podem exceder 500 caracteres")
    private String tags;

    @Size(max = 100, message = "Categoria não pode exceder 100 caracteres")
    private String categoria;
}
