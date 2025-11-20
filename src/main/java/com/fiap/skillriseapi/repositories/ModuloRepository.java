package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    
    @Query("SELECT COUNT(tm.modulo) FROM TrilhaModulo tm WHERE tm.trilha.trilhaId = :trilhaId")
    Long countByTrilhaId(@Param("trilhaId") Long trilhaId);
}
