package com.fiap.skillriseapi.domain.dto.certificado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoResponseDTO {
    private Long certificadoId;
    private Long userId;
    private String userName;
    private Long trilhaId;
    private String trilhaTitle;
    private String codigoVerificacao;
    private LocalDate dataEmissao;
    private LocalDate validadeAte;
}
