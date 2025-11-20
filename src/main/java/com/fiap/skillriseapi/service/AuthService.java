package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.auth.AuthResponseDTO;
import com.fiap.skillriseapi.domain.dto.auth.LoginRequestDTO;
import com.fiap.skillriseapi.domain.dto.auth.RegisterRequestDTO;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.domain.entities.UserRole;
import com.fiap.skillriseapi.infra.errors.exceptions.DuplicateResourceException;
import com.fiap.skillriseapi.infra.errors.exceptions.InvalidCredentialsException;
import com.fiap.skillriseapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDTO register(RegisterRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email já cadastrado");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .birthDate(request.getBirthDate())
                .role(UserRole.USER)
                .build();

        user = userRepository.save(user);


        return AuthResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }

    public AuthResponseDTO login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Email ou senha inválidos"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Email ou senha inválidos");
        }

        return AuthResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
