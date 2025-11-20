package com.fiap.skillriseapi.domain.dto.modulo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuloRequestDTO {

    @NotBlank(message = "Título do módulo é obrigatório")
    @Size(max = 300, message = "Título não pode exceder 300 caracteres")
    private String title;

    private Integer durationMinutes;

    private String contentType;
}
