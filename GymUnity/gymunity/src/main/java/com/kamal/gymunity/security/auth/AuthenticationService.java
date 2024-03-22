package com.kamal.gymunity.security.auth;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamal.gymunity.dto.UtilisateurDto;
import com.kamal.gymunity.dto.UtilisateurResDto;
import com.kamal.gymunity.entities.Token;
import com.kamal.gymunity.entities.Utilisateur;
import com.kamal.gymunity.enumeration.TokenType;
import com.kamal.gymunity.repositories.TokenRepository;
import com.kamal.gymunity.repositories.UtilisateurRepository;
import com.kamal.gymunity.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    public AuthenticationResponse register(UtilisateurDto request) {
        var user = Utilisateur.builder()
                .userName(request.getUserName())
                .prenom(request.getPrenom())
                .nom(request.getNom())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .user(modelMapper.map(savedUser, UtilisateurResDto.class))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user = repository.findByUserName(request.getUserName())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .user(modelMapper.map(user, UtilisateurResDto.class))
                .build();
    }

    private void saveUserToken(Utilisateur user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(Utilisateur user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUtilisateur(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void logout(String username) {
        var user = repository.findByUserName(username).orElseThrow();
        revokeAllUserTokens(user);
    }


}