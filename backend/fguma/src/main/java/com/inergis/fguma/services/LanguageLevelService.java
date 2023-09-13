package com.inergis.fguma.services;

import com.inergis.fguma.entities.LanguageLevel;
import com.inergis.fguma.repositories.languageLevel.LanguageLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageLevelService {

    @Autowired
    private LanguageLevelRepository languageLevelRepository;

    public List<LanguageLevel> getAll() {
        return languageLevelRepository.findAll();
    }

    public LanguageLevel getById(Long id) {
        return languageLevelRepository.findById(id).orElse(null);
    }

    public LanguageLevel save(LanguageLevel languageLevel) {
        return languageLevelRepository.save(languageLevel);
    }

    public void deleteById(Long id) {
        languageLevelRepository.deleteById(id);
    }

    public void delete(LanguageLevel languageLevel) {
        languageLevelRepository.delete(languageLevel);
    }

    public List<LanguageLevel> getByActivity(Long id) {
        return languageLevelRepository.findByActivityId(id);
    }

}