package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.user.UserResponseDTO;
import com.fiap.skillriseapi.domain.dto.user.UserStatsResponseDTO;
import com.fiap.skillriseapi.infra.responses.ApiResponseBuilder;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.service.UserService;
import com.fiap.skillriseapi.specs.UserControllerSpecs;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController implements UserControllerSpecs {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<UserResponseDTO>> findById(@PathVariable Long id) {
        try {
            UserResponseDTO user = userService.findById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(user));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping
    public ResponseEntity<ApiListResponse<UserResponseDTO>> findAll() {
        try {
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(userService.findAll()));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<ApiSingleResponse<UserStatsResponseDTO>> getUserStats(@PathVariable Long id) {
        try {
            UserStatsResponseDTO stats = userService.getUserStats(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(stats));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
