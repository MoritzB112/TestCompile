package com.inergis.fguma.devSessions.controller;

import com.inergis.fguma.converters.UserConverter;
import com.inergis.fguma.devSessions.dto.ResponseDTO;
import com.inergis.fguma.devSessions.dto.UserInputDTO;
import com.inergis.fguma.devSessions.session.InMemorySessionRegistry;
import com.inergis.fguma.entities.User;
import com.inergis.fguma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private InMemorySessionRegistry sessionRegistry;
    @Autowired
    private UserService userService;

    @PostMapping(value = "login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserInputDTO user) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        String sessionToken = sessionRegistry.addSession(user.getEmail());

        User bdUser = userService.getByUsername(user.getEmail());
        return ResponseEntity.ok(new ResponseDTO(sessionToken, UserConverter.toExternal(bdUser)));
    }

    @GetMapping(value = "checkToken")
    public ResponseEntity<String> checkToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        String username = sessionRegistry.getSession(token);
        if(username == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(username);
    }
}
