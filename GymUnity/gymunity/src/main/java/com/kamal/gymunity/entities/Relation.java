package com.kamal.gymunity.entities;


import com.kamal.gymunity.embedded.IdRelation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Relation {


    @EmbeddedId
    private IdRelation id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


}
