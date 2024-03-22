package com.kamal.gymunity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PostLikeDto {
    private Long id;

    @NotBlank(message = "Le contenu ne peut pas être vide")
    private String contenu;

    @NotNull(message = "L'utilisateur ne peut pas être null")
    private Long utilisateurId;
}
