package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    List<Notificacao> findByUser_UserIdOrderByCriadoEmDesc(Long userId);

    List<Notificacao> findByUser_UserIdAndLidaOrderByCriadoEmDesc(Long userId, Boolean lida);

    Long countByUser_UserIdAndLida(Long userId, Boolean lida);

    void deleteByUser_UserId(Long userId);
}
