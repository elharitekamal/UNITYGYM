package com.kamal.gymunity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaDto {
    private Long id;
    private String url;
    private Integer postId;
}
