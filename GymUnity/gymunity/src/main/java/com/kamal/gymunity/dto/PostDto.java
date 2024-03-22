package com.kamal.gymunity.dto;

import com.kamal.gymunity.entities.Media;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PostDto {

    private Integer id;

    @NotBlank(message = "Le titre ne peut pas être vide")
    @Size(max = 100, message = "Le titre ne peut pas dépasser 100 caractères")
    private String titre;

    @NotBlank(message = "Le contenu ne peut pas être vide")
    private String contenu;


}
