package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.RatingType;
import com.inergis.fguma.converters.RatingTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.RatingTypeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ratingType")
public class RatingTypeController {

    @Autowired
    private RatingTypeService ratingTypeService;


    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<RatingType>> getAll() {
        return ResponseEntity.ok(ratingTypeService.getAll().stream().map(RatingTypeConverter::toExternal).toList());
    }
}