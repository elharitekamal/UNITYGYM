package com.kamal.gymunity.dto;

import com.kamal.gymunity.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurResDto {

    private UUID id;
    private String prenom;
    private String nom;
    private String userName;
    private String password;
    private List<Post> posts;



}
