package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.Event;
import com.inergis.fguma.converters.EventConverter;
import com.inergis.fguma.entities.User;
import com.inergis.fguma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.EventService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Event>> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) Boolean includeDown, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        User user = userService.getByToken(token);
        return ResponseEntity.ok(eventService.getAll(name, includeDown).stream().filter(event -> {
            if (user == null) {
                return false;
            }
            if (user.getAppUser() == null) {
                return false;
            }
            return event.getEdition().getDepartment().getId().equals(user.getAppUser().getDepartment().getId());
        }).map(EventConverter::toExternalForList).toList());
    }
}