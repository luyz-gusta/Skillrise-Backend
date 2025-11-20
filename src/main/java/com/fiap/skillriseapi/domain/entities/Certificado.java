package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CERTIFICADO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificado_seq")
    @SequenceGenerator(name = "certificado_seq", sequenceName = "TB_CERTIFICADO_ID_SEQ", allocationSize = 1)
    @Column(name = "CERTIFICADO_ID")
    private Long certificadoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRILHA_ID", nullable = false)
    private Trilha trilha;

    @Column(name = "CODIGO_VERIFICACAO", nullable = false, unique = true, length = 100)
    private String codigoVerificacao;

    @Column(name = "DATA_EMISSAO", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "VALIDADE_ATE")
    private LocalDate validadeAte;

    @PrePersist
    protected void onCreate() {
        if (dataEmissao == null) {
            dataEmissao = LocalDate.now();
        }
        if (codigoVerificacao == null) {
            codigoVerificacao = generateCodigoVerificacao();
        }
    }

    private String generateCodigoVerificacao() {
        String year = String.valueOf(LocalDate.now().getYear());
        String random = String.format("%06d", (int) (Math.random() * 1000000));
        return "CERT-" + year + "-" + random;
    }
}
