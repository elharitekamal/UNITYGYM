package com.kamal.gymunity.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private String contenu;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "post")
    private List<Media> media;

    @OneToMany(mappedBy = "post")
    private List<Commentaire> commentaires;


    @OneToMany(mappedBy = "post")
    private List<PostLike> postLikes;



}
