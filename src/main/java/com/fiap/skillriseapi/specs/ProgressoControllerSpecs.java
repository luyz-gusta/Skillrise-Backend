package com.fiap.skillriseapi.specs;

import com.fiap.skillriseapi.domain.dto.progresso.ProgressoResponseDTO;
import com.fiap.skillriseapi.domain.dto.progresso.ProgressoUpdateDTO;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Progresso", description = "Acompanhamento de progresso dos usuários")
@SecurityRequirement(name = "bearer-jwt")
@ApiResponseInternalServerError
@ApiResponseUnauthorized
public interface ProgressoControllerSpecs {

    @Operation(summary = "Atualizar progresso em módulo", description = "Atualiza o progresso do usuário em um módulo")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ProgressoResponseDTO>> updateProgress(
            @RequestParam Long inscricaoId,
            @RequestParam Long moduloId,
            @Valid @RequestBody ProgressoUpdateDTO request
    );

    @Operation(summary = "Buscar progresso por inscrição", description = "Retorna o progresso de uma inscrição específica")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<ProgressoResponseDTO>> findByInscricaoId(@PathVariable Long inscricaoId);
}
