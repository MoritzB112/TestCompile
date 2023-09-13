package com.inergis.fguma.repositories.ratingType;

import com.inergis.fguma.entities.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingTypeRepository extends JpaRepository<RatingType, Long> {

}