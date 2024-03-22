package com.kamal.gymunity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDto {

    @NotNull(message = "Le sender ne peut pas être null")
    private Integer senderId;

    @NotNull(message = "Le recipient ne peut pas être null")
    private Integer recipientId;

    @NotBlank(message = "Le contenu ne peut pas être vide")
    private String contenu;


}
