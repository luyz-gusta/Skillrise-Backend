package com.fiap.skillriseapi.domain.dto.notificacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoResponseDTO {
    private Long notificacaoId;
    private Long userId;
    private String titulo;
    private String mensagem;
    private String tipo;
    private String icone;
    private String link;
    private Boolean lida;
    private LocalDate criadoEm;
}
