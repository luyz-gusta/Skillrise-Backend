package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    List<Achievement> findByUser_UserId(Long userId);

    List<Achievement> findByUser_UserIdAndTipo(Long userId, String tipo);

    List<Achievement> findByUser_UserIdAndRaridade(Long userId, String raridade);

    Long countByUser_UserId(Long userId);

    boolean existsByUser_UserIdAndNome(Long userId, String nome);
}
