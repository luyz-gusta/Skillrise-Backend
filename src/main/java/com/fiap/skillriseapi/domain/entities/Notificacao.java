package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_NOTIFICACAO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificacao_seq")
    @SequenceGenerator(name = "notificacao_seq", sequenceName = "TB_NOTIFICACAO_ID_SEQ", allocationSize = 1)
    @Column(name = "NOTIFICACAO_ID")
    private Long notificacaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "TITULO", nullable = false, length = 200)
    private String titulo;

    @Column(name = "MENSAGEM", nullable = false, length = 1000)
    private String mensagem;

    @Column(name = "TIPO", length = 50)
    private String tipo; // ACHIEVEMENT, CERTIFICADO, TRILHA, OPORTUNIDADE, GERAL

    @Column(name = "ICONE", length = 100)
    private String icone; // Nome do ícone Lucide React

    @Column(name = "LINK", length = 500)
    private String link;

    @Column(name = "LIDA", nullable = false)
    private Boolean lida;

    @Column(name = "CRIADO_EM", nullable = false)
    private LocalDate criadoEm;

    @PrePersist
    protected void onCreate() {
        if (criadoEm == null) {
            criadoEm = LocalDate.now();
        }
        if (lida == null) {
            lida = false;
        }
        if (tipo == null) {
            tipo = "GERAL";
        }
    }
}
