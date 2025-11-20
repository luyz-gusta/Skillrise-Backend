package com.fiap.skillriseapi.domain.dto.skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillResponseDTO {
    private Long skillId;
    private String name;
    private String description;
}
