package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.trilha.TrilhaRequestDTO;
import com.fiap.skillriseapi.domain.dto.trilha.TrilhaResponseDTO;
import com.fiap.skillriseapi.infra.responses.ApiResponseBuilder;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.service.TrilhaService;
import com.fiap.skillriseapi.specs.TrilhaControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/trilhas")
public class TrilhaController implements TrilhaControllerSpecs {

    private final TrilhaService trilhaService;

    @GetMapping
    public ResponseEntity<ApiListResponse<TrilhaResponseDTO>> findAll() {
        try {
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(trilhaService.findAll()));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<TrilhaResponseDTO>> findById(@PathVariable Long id) {
        try {
            TrilhaResponseDTO trilha = trilhaService.findById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(trilha));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiSingleResponse<TrilhaResponseDTO>> create(@Valid @RequestBody TrilhaRequestDTO request) {
        try {
            TrilhaResponseDTO trilha = trilhaService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(trilha));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiSingleResponse<TrilhaResponseDTO>> update(
            @PathVariable Long id,
            @Valid @RequestBody TrilhaRequestDTO request
    ) {
        try {
            TrilhaResponseDTO trilha = trilhaService.update(id, request);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(trilha));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id) {
        try {
            trilhaService.delete(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
