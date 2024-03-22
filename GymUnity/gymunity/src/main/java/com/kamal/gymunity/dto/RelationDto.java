package com.kamal.gymunity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelationDto {

    @NotNull(message = "Le following ne peut pas être null")
    private Long followingId;

    @NotNull(message = "Le follower ne peut pas être null")
    private Long followerId;
}
