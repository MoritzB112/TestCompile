package com.inergis.fguma.services;

import com.inergis.fguma.entities.Modality;
import com.inergis.fguma.repositories.modality.ModalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModalityService {

    @Autowired
    private ModalityRepository modalityRepository;

    public List<Modality> getAll() {
        return modalityRepository.findAll();
    }

    public Modality getById(Long id) {
        return modalityRepository.findById(id).orElse(null);
    }

    public Modality save(Modality modality) {
        return modalityRepository.save(modality);
    }

    public void deleteById(Long id) {
        modalityRepository.deleteById(id);
    }

    public void delete(Modality modality) {
        modalityRepository.delete(modality);
    }

}