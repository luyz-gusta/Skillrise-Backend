package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {

    List<Certificado> findByUser_UserId(Long userId);

    Optional<Certificado> findByCodigoVerificacao(String codigoVerificacao);

    boolean existsByUser_UserIdAndTrilha_TrilhaId(Long userId, Long trilhaId);
    
    Long countByUser_UserId(Long userId);
}
