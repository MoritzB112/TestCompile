package com.inergis.fguma.devSessions.dto;


import com.inergis.fguma.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String token;
    private User user;
}
