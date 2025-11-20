package com.fiap.skillriseapi.domain.dto.skill;

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
public class SkillRequestDTO {

    @NotBlank(message = "Nome da skill é obrigatório")
    @Size(max = 150, message = "Nome não pode exceder 150 caracteres")
    private String name;

    @Size(max = 4000, message = "Descrição não pode exceder 4000 caracteres")
    private String description;
}
