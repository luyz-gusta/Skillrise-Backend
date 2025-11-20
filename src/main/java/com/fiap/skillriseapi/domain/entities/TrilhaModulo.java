package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_TRILHA_MODULO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrilhaModulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trilha_modulo_seq")
    @SequenceGenerator(name = "trilha_modulo_seq", sequenceName = "TB_TRILHA_MODULO_ID_SEQ", allocationSize = 1)
    @Column(name = "TRILHA_MODULO_ID")
    private Long trilhaModuloId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRILHA_ID", nullable = false)
    private Trilha trilha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODULO_ID", nullable = false)
    private Modulo modulo;

    @Column(name = "MODULE_ORDER")
    private Integer moduleOrder;
}
