package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.Headquarter;
import com.inergis.fguma.converters.HeadquarterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.HeadquarterService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/headquarter")
public class HeadquarterController {

    @Autowired
    private HeadquarterService headquarterService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Headquarter>> getAll() {
        return ResponseEntity.ok(headquarterService.getAll().stream().map(HeadquarterConverter::toExternal).toList());
    }
}