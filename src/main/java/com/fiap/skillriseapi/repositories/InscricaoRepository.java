package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByUser_UserId(Long userId);
    List<Inscricao> findByTrilha_TrilhaId(Long trilhaId);
    Optional<Inscricao> findByUser_UserIdAndTrilha_TrilhaId(Long userId, Long trilhaId);
    Long countByUser_UserId(Long userId);
    Long countByUser_UserIdAndDataConclusaoIsNotNull(Long userId);
}
