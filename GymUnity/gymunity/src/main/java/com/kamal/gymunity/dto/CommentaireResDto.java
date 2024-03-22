package com.kamal.gymunity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class CommentaireResDto {
    private Long id;
    private LocalDate date;
    private String contenu;
    private UtilisateurDto utilisateur;
    private PostDto post;
    private List<CommentLikeDto> commentLikes;
}
