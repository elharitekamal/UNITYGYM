package com.kamal.gymunity.security.auth;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.kamal.gymunity.dto.UtilisateurResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    private UtilisateurResDto user;
}
