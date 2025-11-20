package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.inscricao.InscricaoResponseDTO;
import com.fiap.skillriseapi.infra.responses.ApiResponseBuilder;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.service.InscricaoService;
import com.fiap.skillriseapi.specs.InscricaoControllerSpecs;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/inscricoes")
public class InscricaoController implements InscricaoControllerSpecs {

    private final InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity<ApiSingleResponse<InscricaoResponseDTO>> enrollUser(
            @RequestParam Long userId,
            @RequestParam Long trilhaId
    ) {
        try {
            InscricaoResponseDTO inscricao = inscricaoService.enrollUser(userId, trilhaId);
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(inscricao));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiListResponse<InscricaoResponseDTO>> findByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(inscricaoService.findByUserId(userId)));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/trilha/{trilhaId}")
    public ResponseEntity<ApiListResponse<InscricaoResponseDTO>> findByTrilhaId(@PathVariable Long trilhaId) {
        try {
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(inscricaoService.findByTrilhaId(trilhaId)));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
