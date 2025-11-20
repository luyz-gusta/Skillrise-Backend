package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_OPORTUNIDADE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Oportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oportunidade_seq")
    @SequenceGenerator(name = "oportunidade_seq", sequenceName = "TB_OPORTUNIDADE_ID_SEQ", allocationSize = 1)
    @Column(name = "OPORTUNIDADE_ID")
    private Long oportunidadeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPRESA_ID", nullable = false)
    private Empresa empresa;

    @Column(name = "TITLE", nullable = false, length = 300)
    private String title;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "REQUIRED_SKILLS", length = 1000)
    private String requiredSkills;

    @Column(name = "POSTED_AT", nullable = false)
    private LocalDate postedAt;

    @Column(name = "SALARIO_MIN", precision = 10, scale = 2)
    private BigDecimal salarioMin;

    @Column(name = "SALARIO_MAX", precision = 10, scale = 2)
    private BigDecimal salarioMax;

    @Column(name = "NIVEL", length = 50)
    private String nivel;

    @Column(name = "LOCALIZACAO", length = 200)
    private String localizacao;

    @Column(name = "TIPO_CONTRATO", length = 50)
    private String tipoContrato;

    @Column(name = "STATUS", length = 20)
    private String status;

    @ManyToMany
    @JoinTable(
        name = "TB_TRILHA_OPORTUNIDADE",
        joinColumns = @JoinColumn(name = "OPORTUNIDADE_ID"),
        inverseJoinColumns = @JoinColumn(name = "TRILHA_ID")
    )
    @Builder.Default
    private Set<Trilha> trilhas = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        if (postedAt == null) {
            postedAt = LocalDate.now();
        }
        if (status == null) {
            status = "ATIVA";
        }
    }
}
