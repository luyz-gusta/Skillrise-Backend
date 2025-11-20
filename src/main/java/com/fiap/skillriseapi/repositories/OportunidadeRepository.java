package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
    List<Oportunidade> findByEmpresa_EmpresaId(Long empresaId);
    
    List<Oportunidade> findByStatus(String status);
    
    @Query("SELECT DISTINCT o FROM Oportunidade o LEFT JOIN FETCH o.empresa LEFT JOIN o.trilhas t WHERE t.trilhaId = :trilhaId AND o.status = 'ATIVA'")
    List<Oportunidade> findByTrilhaId(@Param("trilhaId") Long trilhaId);
}
