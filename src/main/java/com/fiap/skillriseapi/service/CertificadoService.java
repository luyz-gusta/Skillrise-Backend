package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.certificado.CertificadoResponseDTO;
import com.fiap.skillriseapi.domain.entities.Certificado;
import com.fiap.skillriseapi.domain.entities.Inscricao;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.domain.entities.Trilha;
import com.fiap.skillriseapi.infra.errors.exceptions.BusinessException;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.CertificadoRepository;
import com.fiap.skillriseapi.repositories.InscricaoRepository;
import com.fiap.skillriseapi.repositories.UserRepository;
import com.fiap.skillriseapi.repositories.TrilhaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CertificadoService {

    private final CertificadoRepository certificadoRepository;
    private final InscricaoRepository inscricaoRepository;
    private final UserRepository userRepository;
    private final TrilhaRepository trilhaRepository;
    private final NotificacaoService notificacaoService;

    @Transactional
    public CertificadoResponseDTO gerarCertificado(Long inscricaoId) {
        log.info("Gerando certificado para inscricaoId: {}", inscricaoId);

        Inscricao inscricao = inscricaoRepository.findById(inscricaoId)
                .orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada"));
        
        if (certificadoRepository.existsByUser_UserIdAndTrilha_TrilhaId(
                inscricao.getUser().getUserId(), inscricao.getTrilha().getTrilhaId())) {
            throw new BusinessException("Certificado já foi gerado para esta trilha");
        }

        if (!inscricao.isConcluida()) {
            throw new BusinessException("Certificado só pode ser gerado após conclusão da trilha");
        }

        Certificado certificado = Certificado.builder()
                .user(inscricao.getUser())
                .trilha(inscricao.getTrilha())
                .build();

        certificado = certificadoRepository.save(certificado);

        notificacaoService.criarNotificacao(
                inscricao.getUser().getUserId(),
                "Certificado Disponível! 🎉",
                "Parabéns! Seu certificado de \"" + inscricao.getTrilha().getTitle() + "\" está pronto.",
                "CERTIFICADO",
                "FileCheck",
                "/perfil"
        );

        log.info("Certificado gerado com sucesso: {}", certificado.getCodigoVerificacao());
        return mapToDTO(certificado);
    }

    public List<CertificadoResponseDTO> listarPorUsuario(Long userId) {
        log.info("Listando certificados do usuário: {}", userId);
        
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        return certificadoRepository.findByUser_UserId(userId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CertificadoResponseDTO buscarPorCodigoVerificacao(String codigoVerificacao) {
        log.info("Buscando certificado por código de verificação: {}", codigoVerificacao);
        
        Certificado certificado = certificadoRepository.findByCodigoVerificacao(codigoVerificacao)
                .orElseThrow(() -> new ResourceNotFoundException("Certificado não encontrado com código: " + codigoVerificacao));
        
        return mapToDTO(certificado);
    }

    public CertificadoResponseDTO buscarPorId(Long id) {
        Certificado certificado = certificadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certificado não encontrado"));
        
        return mapToDTO(certificado);
    }



    private CertificadoResponseDTO mapToDTO(Certificado certificado) {
        return CertificadoResponseDTO.builder()
                .certificadoId(certificado.getCertificadoId())
                .userId(certificado.getUser().getUserId())
                .userName(certificado.getUser().getName())
                .trilhaId(certificado.getTrilha().getTrilhaId())
                .trilhaTitle(certificado.getTrilha().getTitle())
                .codigoVerificacao(certificado.getCodigoVerificacao())
                .dataEmissao(certificado.getDataEmissao())
                .validadeAte(certificado.getValidadeAte())
                .build();
    }
}
