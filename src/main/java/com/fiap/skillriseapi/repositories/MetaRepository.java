package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

    List<Meta> findByUser_UserId(Long userId);

    List<Meta> findByUser_UserIdAndStatus(Long userId, String status);

    List<Meta> findByUser_UserIdAndTipo(Long userId, String tipo);

    Long countByUser_UserIdAndStatus(Long userId, String status);
}
