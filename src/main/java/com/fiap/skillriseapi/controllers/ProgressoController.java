package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.progresso.ProgressoResponseDTO;
import com.fiap.skillriseapi.domain.dto.progresso.ProgressoUpdateDTO;
import com.fiap.skillriseapi.infra.responses.ApiResponseBuilder;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.service.ProgressoService;
import com.fiap.skillriseapi.specs.ProgressoControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/progresso")
public class ProgressoController implements ProgressoControllerSpecs {

    private final ProgressoService progressoService;

    @PutMapping
    public ResponseEntity<ApiSingleResponse<ProgressoResponseDTO>> updateProgress(
            @RequestParam Long inscricaoId,
            @RequestParam Long moduloId,
            @Valid @RequestBody ProgressoUpdateDTO request
    ) {
        try {
            ProgressoResponseDTO progresso = progressoService.updateProgress(inscricaoId, moduloId, request);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(progresso));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/inscricao/{inscricaoId}")
    public ResponseEntity<ApiListResponse<ProgressoResponseDTO>> findByInscricaoId(@PathVariable Long inscricaoId) {
        try {
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(progressoService.findByInscricaoId(inscricaoId)));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
