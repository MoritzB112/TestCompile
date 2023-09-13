package com.inergis.fguma.services;

import com.inergis.fguma.entities.RatingType;
import com.inergis.fguma.repositories.ratingType.RatingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RatingTypeService {

    @Autowired
    private RatingTypeRepository ratingTypeRepository;

    public List<RatingType> getAll() {
        return ratingTypeRepository.findAll();
    }

    public RatingType getById(Long id) {
        return ratingTypeRepository.findById(id).orElse(null);
    }

    public RatingType save(RatingType ratingType) {
        return ratingTypeRepository.save(ratingType);
    }

    public void deleteById(Long id) {
        ratingTypeRepository.deleteById(id);
    }

    public void delete(RatingType ratingType) {
        ratingTypeRepository.delete(ratingType);
    }

}