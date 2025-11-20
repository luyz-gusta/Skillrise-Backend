package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Recomendacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Long> {
    List<Recomendacao> findByUser_UserIdOrderByScoreDesc(Long userId);
}
