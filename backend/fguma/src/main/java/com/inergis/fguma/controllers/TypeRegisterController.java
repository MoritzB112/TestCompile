package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.TypeRegister;
import com.inergis.fguma.converters.TypeRegisterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.TypeRegisterService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/typeRegister")
public class TypeRegisterController {

    @Autowired
    private TypeRegisterService typeRegisterService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<TypeRegister>> getAll() {
        return ResponseEntity.ok(typeRegisterService.getAll().stream().map(TypeRegisterConverter::toExternal).toList());
    }
}