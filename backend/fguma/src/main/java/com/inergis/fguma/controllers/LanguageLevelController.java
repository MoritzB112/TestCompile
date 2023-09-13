package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.LanguageLevel;
import com.inergis.fguma.converters.LanguageLevelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.LanguageLevelService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/languageLevel")
public class LanguageLevelController {

    @Autowired
    private LanguageLevelService languageLevelService;

    @GetMapping(value = "/byActivity/{id}", produces = "application/json")
    public ResponseEntity<List<LanguageLevel>> getByActivity(@PathVariable("id") Long id) {
        return ResponseEntity.ok(languageLevelService.getByActivity(id).stream().map(LanguageLevelConverter::toExternal).toList());
    }
}