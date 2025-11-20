package com.fiap.skillriseapi.domain.dto.achievement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AchievementResponseDTO {
    private Long achievementId;
    private Long userId;
    private String tipo;
    private String nome;
    private String descricao;
    private String icone;
    private Integer xpGanho;
    private LocalDate desbloqueadoEm;
    private String raridade;
}
