package com.fiap.skillriseapi.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStatsResponseDTO {
    // Dados básicos do usuário
    private Long userId;
    private String name;
    private String email;
    
    // Gamificação
    private Integer xp;
    private Integer level;
    private Integer xpProximoLevel;
    private Integer streakDias;
    private LocalDate ultimoAcesso;
    
    // Estatísticas de progresso
    private Long totalInscricoes;
    private Long trilhasCompletas;
    private Long totalModulosProgresso;
    private Long modulosCompletos;
    private Long totalCertificados;
    private Long totalAchievements;
    
    // Médias e taxas
    private Double taxaConclusao; // % de trilhas completadas
    private Integer horasEstudadas; // Estimativa
}
