package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.TrilhaModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrilhaModuloRepository extends JpaRepository<TrilhaModulo, Long> {
    List<TrilhaModulo> findByTrilha_TrilhaIdOrderByModuleOrderAsc(Long trilhaId);
}
