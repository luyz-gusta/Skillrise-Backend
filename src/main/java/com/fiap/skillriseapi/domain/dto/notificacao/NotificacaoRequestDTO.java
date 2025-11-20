package com.fiap.skillriseapi.domain.dto.notificacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoRequestDTO {

    @NotNull(message = "ID do usuário é obrigatório")
    private Long userId;

    @NotBlank(message = "Título é obrigatório")
    @Size(max = 200, message = "Título não pode exceder 200 caracteres")
    private String titulo;

    @NotBlank(message = "Mensagem é obrigatória")
    @Size(max = 1000, message = "Mensagem não pode exceder 1000 caracteres")
    private String mensagem;

    private String tipo; // ACHIEVEMENT, CERTIFICADO, TRILHA, OPORTUNIDADE, GERAL

    private String icone;

    private String link;
}
