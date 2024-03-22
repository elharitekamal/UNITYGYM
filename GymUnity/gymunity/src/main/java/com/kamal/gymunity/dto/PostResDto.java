package com.kamal.gymunity.dto;

import com.kamal.gymunity.entities.Media;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class PostResDto {

    private Integer id;

    private String titre;

    private String contenu;

    private LocalDate date;

    private List<MediaResDto> media;
    private List<CommentaireResDto> commentaires;
    private List<PostResDto> postLikes;
}
