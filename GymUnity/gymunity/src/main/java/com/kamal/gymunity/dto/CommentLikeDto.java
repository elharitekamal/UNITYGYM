package com.kamal.gymunity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentLikeDto {
    private Long id;

    @NotNull(message = "L'utilisateur ne peut pas être null")
    private Long utilisateurId;

    @NotNull(message = "Le commentaire ne peut pas être null")
    private Long commentaireId;
}
