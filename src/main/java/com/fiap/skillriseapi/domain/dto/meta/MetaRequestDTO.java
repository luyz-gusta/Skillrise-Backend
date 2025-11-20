package com.fiap.skillriseapi.domain.dto.meta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaRequestDTO {

    @NotNull(message = "ID do usuário é obrigatório")
    private Long userId;

    @NotBlank(message = "Título é obrigatório")
    @Size(max = 300, message = "Título não pode exceder 300 caracteres")
    private String titulo;

    @Size(max = 1000, message = "Descrição não pode exceder 1000 caracteres")
    private String descricao;

    private String tipo; // TRILHA, MODULO, SKILL, XP, TEMPO

    @NotNull(message = "Valor alvo é obrigatório")
    private Integer targetValue;

    private LocalDate prazo;
}
