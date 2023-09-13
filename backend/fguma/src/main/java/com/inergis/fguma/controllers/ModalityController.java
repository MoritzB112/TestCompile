package com.inergis.fguma.controllers;

import com.inergis.fguma.converters.ModalityConverter;
import com.inergis.fguma.entities.Modality;
import com.inergis.fguma.entities.User;
import com.inergis.fguma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.ModalityService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/modality")
public class ModalityController {

    @Autowired
    private ModalityService modalityService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Modality>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        User user = userService.getByToken(token);
        return ResponseEntity.ok(modalityService.getAll().stream().filter(modality -> {
            if (user == null) {
                return false;
            }
            if (user.getAppUser() == null) {
                return false;
            }
            return modality.getDepartment().getId().equals(user.getAppUser().getDepartment().getId());
        }).map(ModalityConverter::toExternal).toList());
    }
}