package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.auth.AuthResponseDTO;
import com.fiap.skillriseapi.domain.dto.auth.LoginRequestDTO;
import com.fiap.skillriseapi.domain.dto.auth.RegisterRequestDTO;
import com.fiap.skillriseapi.infra.responses.ApiResponseBuilder;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.service.AuthService;
import com.fiap.skillriseapi.specs.AuthControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController implements AuthControllerSpecs {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiSingleResponse<AuthResponseDTO>> register(@Valid @RequestBody RegisterRequestDTO request) {
        AuthResponseDTO response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(response));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiSingleResponse<AuthResponseDTO>> login(@Valid @RequestBody LoginRequestDTO request) {
        AuthResponseDTO response = authService.login(request);
        return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(response));
    }
}
