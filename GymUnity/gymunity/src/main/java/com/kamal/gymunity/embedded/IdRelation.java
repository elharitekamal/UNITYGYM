package com.kamal.gymunity.embedded;

import com.kamal.gymunity.entities.Utilisateur;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Embeddable
public class IdRelation implements Serializable {
    @ManyToOne
    private Utilisateur following;
    @ManyToOne
    private Utilisateur follower;

}
