package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.DiplomaType;
import com.inergis.fguma.converters.DiplomaTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.DiplomaTypeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/diplomaType")
public class DiplomaTypeController {

    @Autowired
    private DiplomaTypeService diplomaTypeService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<DiplomaType>> getAll() {
        return ResponseEntity.ok(diplomaTypeService.getAll().stream().map(DiplomaTypeConverter::toExternal).toList());
    }
}