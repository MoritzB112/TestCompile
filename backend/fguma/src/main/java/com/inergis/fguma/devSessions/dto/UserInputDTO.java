package com.inergis.fguma.devSessions.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInputDTO {
    private String email;
    private String password;
}
