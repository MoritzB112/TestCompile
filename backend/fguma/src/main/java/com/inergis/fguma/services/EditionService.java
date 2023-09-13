package com.inergis.fguma.services;

import com.inergis.fguma.entities.Edition;
import com.inergis.fguma.repositories.edition.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EditionService {

    @Autowired
    private EditionRepository editionRepository;

    public List<Edition> getAll() {
        return editionRepository.findAll();
    }

    public Edition getById(Long id) {
        return editionRepository.findById(id).orElse(null);
    }

    public Edition save(Edition edition) {
        return editionRepository.save(edition);
    }

    public void deleteById(Long id) {
        editionRepository.deleteById(id);
    }

    public void delete(Edition edition) {
        editionRepository.delete(edition);
    }

}