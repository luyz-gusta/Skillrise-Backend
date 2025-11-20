package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
    List<Trilha> findByDifficulty(String difficulty);
}
