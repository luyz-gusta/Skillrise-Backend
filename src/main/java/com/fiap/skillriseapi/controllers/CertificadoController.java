package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.certificado.CertificadoResponseDTO;
import com.fiap.skillriseapi.service.CertificadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificados")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CertificadoController {

    private final CertificadoService certificadoService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CertificadoResponseDTO>> listarPorUsuario(@PathVariable Long userId) {
        List<CertificadoResponseDTO> certificados = certificadoService.listarPorUsuario(userId);
        return ResponseEntity.ok(certificados);
    }

    @GetMapping("/verificar/{codigoVerificacao}")
    public ResponseEntity<CertificadoResponseDTO> buscarPorCodigoVerificacao(@PathVariable String codigoVerificacao) {
        CertificadoResponseDTO certificado = certificadoService.buscarPorCodigoVerificacao(codigoVerificacao);
        return ResponseEntity.ok(certificado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificadoResponseDTO> buscarPorId(@PathVariable Long id) {
        CertificadoResponseDTO certificado = certificadoService.buscarPorId(id);
        return ResponseEntity.ok(certificado);
    }

    @PostMapping("/inscricao/{inscricaoId}")
    public ResponseEntity<CertificadoResponseDTO> gerarCertificado(@PathVariable Long inscricaoId) {
        CertificadoResponseDTO certificado = certificadoService.gerarCertificado(inscricaoId);
        return ResponseEntity.ok(certificado);
    }
}
