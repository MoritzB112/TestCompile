package com.inergis.fguma.services;

import com.inergis.fguma.entities.Headquarter;
import com.inergis.fguma.repositories.headquarter.HeadquarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HeadquarterService {

    @Autowired
    private HeadquarterRepository headquarterRepository;

    public List<Headquarter> getAll() {
        return headquarterRepository.findAll();
    }

    public Headquarter getById(Long id) {
        return headquarterRepository.findById(id).orElse(null);
    }

    public Headquarter save(Headquarter headquarter) {
        return headquarterRepository.save(headquarter);
    }

    public void deleteById(Long id) {
        headquarterRepository.deleteById(id);
    }

    public void delete(Headquarter headquarter) {
        headquarterRepository.delete(headquarter);
    }

}