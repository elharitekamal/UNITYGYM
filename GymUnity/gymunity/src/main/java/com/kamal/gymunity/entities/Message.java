package com.kamal.gymunity.entities;

import com.kamal.gymunity.embedded.IdMessage;
import com.kamal.gymunity.embedded.IdRelation;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Message {
    @EmbeddedId
    private IdMessage id;

    private LocalDate date;

    private String contenu;

}
