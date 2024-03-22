package com.kamal.gymunity.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MessageResDto {
    private UtilisateurDto sender;
    private UtilisateurDto recipient;
    private LocalDate date;
    private String contenu;
}
