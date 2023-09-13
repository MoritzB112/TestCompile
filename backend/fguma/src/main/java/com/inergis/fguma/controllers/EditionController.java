package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.Edition;
import com.inergis.fguma.converters.EditionConverter;
import com.inergis.fguma.entities.User;
import com.inergis.fguma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.EditionService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/edition")
public class EditionController {

    @Autowired
    private EditionService editionService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Edition>> get(@RequestParam(required = false) String name, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        User user = userService.getByToken(token);
        return ResponseEntity.ok(editionService.getAll().stream().filter(edition -> {
            if (user == null) {
                return false;
            }
            if (user.getAppUser() == null) {
                return false;
            }
            return edition.getDepartment().getId().equals(user.getAppUser().getDepartment().getId());
        }).map(EditionConverter::toExternalForList).toList());
    }
}