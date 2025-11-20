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
public class UserResponseDTO {
    private Long userId;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String role;
    private LocalDate createdAt;
    private Integer xp;
    private Integer level;
    private Integer streakDias;
    private LocalDate ultimoAcesso;
}
