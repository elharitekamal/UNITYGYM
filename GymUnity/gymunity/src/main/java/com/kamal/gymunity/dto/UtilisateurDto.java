package com.kamal.gymunity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class UtilisateurDto {

    @NotBlank(message = "Le prénom ne peut pas être vide")
    @Size(max = 50, message = "Le prénom ne peut pas dépasser {max} caractères")
    private String prenom;

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(max = 50, message = "Le nom ne peut pas dépasser {max} caractères")
    private String nom;

    @NotBlank(message = "L'email ne peut pas être vide")
    private String userName;

    @NotBlank(message = "L'email ne peut pas être vide")
    private String password;


    private List<RelationDto> relations;
    private List<PostDto> posts;
    private List<CommentaireDto> commentaires;
}
