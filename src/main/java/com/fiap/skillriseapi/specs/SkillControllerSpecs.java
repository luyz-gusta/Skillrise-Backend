package com.fiap.skillriseapi.specs;

import com.fiap.skillriseapi.domain.dto.skill.SkillRequestDTO;
import com.fiap.skillriseapi.domain.dto.skill.SkillResponseDTO;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
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
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Skills", description = "Gerenciamento de habilidades")
@ApiResponseInternalServerError
public interface SkillControllerSpecs {

    @Operation(summary = "Listar todas as skills", description = "Retorna lista com todas as habilidades disponíveis")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<SkillResponseDTO>> findAll();

    @Operation(summary = "Buscar skill por ID", description = "Retorna os detalhes de uma habilidade específica")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<SkillResponseDTO>> findById(@PathVariable Long id);

    @Operation(summary = "Criar nova skill", description = "Cria uma nova habilidade no sistema (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseBadRequest
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<SkillResponseDTO>> create(@Valid @RequestBody SkillRequestDTO request);

    @Operation(summary = "Atualizar skill", description = "Atualiza os dados de uma habilidade existente (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<SkillResponseDTO>> update(@PathVariable Long id, @Valid @RequestBody SkillRequestDTO request);

    @Operation(summary = "Deletar skill", description = "Remove uma habilidade do sistema (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseNotFound
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id);
}
