package com.inergis.fguma.services;

import com.inergis.fguma.entities.DiplomaType;
import com.inergis.fguma.repositories.diplomaType.DiplomaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiplomaTypeService {

    @Autowired
    private DiplomaTypeRepository diplomaTypeRepository;

    public List<DiplomaType> getAll() {
        return diplomaTypeRepository.findAll();
    }

    public DiplomaType getById(Long id) {
        return diplomaTypeRepository.findById(id).orElse(null);
    }

    public DiplomaType save(DiplomaType diplomaType) {
        return diplomaTypeRepository.save(diplomaType);
    }

    public void deleteById(Long id) {
        diplomaTypeRepository.deleteById(id);
    }

    public void delete(DiplomaType diplomaType) {
        diplomaTypeRepository.delete(diplomaType);
    }

}