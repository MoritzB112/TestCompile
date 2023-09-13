package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.Schedule;
import com.inergis.fguma.converters.ScheduleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.ScheduleService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/activity/{id}", produces = "application/json")
    public ResponseEntity<List<Schedule>> getForActivity(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getByActivityId(id).stream().map(ScheduleConverter::toExternalForLIst).toList());
    }
}