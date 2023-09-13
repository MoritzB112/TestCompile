package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.Language;
import com.inergis.fguma.converters.LanguageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.LanguageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Iterable<Language>> getAll() {
        return ResponseEntity.ok(languageService.getAll().stream().map(LanguageConverter::toExternal).toList());
    }
}