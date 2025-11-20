package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Progresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressoRepository extends JpaRepository<Progresso, Long> {
    List<Progresso> findByInscricao_InscricaoId(Long inscricaoId);
    Optional<Progresso> findByInscricao_InscricaoIdAndModulo_ModuloId(Long inscricaoId, Long moduloId);
    Long countByInscricao_User_UserIdAndPercentage(Long userId, Double percentage);
}
