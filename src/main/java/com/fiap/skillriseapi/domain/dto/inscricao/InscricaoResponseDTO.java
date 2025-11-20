package com.fiap.skillriseapi.domain.dto.inscricao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscricaoResponseDTO {
    private Long inscricaoId;
    private Long userId;
    private Long trilhaId;
    private String trilhaTitle;
    private LocalDate dataInscricao;
    private LocalDate dataConclusao;
    private String status;
}
