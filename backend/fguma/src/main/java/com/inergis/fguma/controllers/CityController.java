package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.City;
import com.inergis.fguma.converters.CityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.CityService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<City>> getAll() {
        return ResponseEntity.ok(cityService.getAll().stream().map(CityConverter::toExternal).toList());
    }
}