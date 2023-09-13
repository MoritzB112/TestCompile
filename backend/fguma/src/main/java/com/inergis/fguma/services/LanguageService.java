package com.inergis.fguma.services;

import com.inergis.fguma.entities.Language;
import com.inergis.fguma.repositories.language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    public Language getById(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }

    public void delete(Language language) {
        languageRepository.delete(language);
    }

}