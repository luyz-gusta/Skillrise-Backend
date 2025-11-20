package com.fiap.skillriseapi.specs;

import com.fiap.skillriseapi.domain.dto.inscricao.InscricaoResponseDTO;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Inscrições", description = "Gerenciamento de inscrições em trilhas")
@SecurityRequirement(name = "bearer-jwt")
@ApiResponseInternalServerError
@ApiResponseUnauthorized
public interface InscricaoControllerSpecs {

    @Operation(summary = "Inscrever usuário em trilha", description = "Inscreve um usuário em uma trilha de aprendizado")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<InscricaoResponseDTO>> enrollUser(@RequestParam Long userId, @RequestParam Long trilhaId);

    @Operation(summary = "Listar inscrições do usuário", description = "Retorna todas as inscrições de um usuário")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<InscricaoResponseDTO>> findByUserId(@PathVariable Long userId);

    @Operation(summary = "Listar inscrições na trilha", description = "Retorna todas as inscrições em uma trilha")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<InscricaoResponseDTO>> findByTrilhaId(@PathVariable Long trilhaId);
}
