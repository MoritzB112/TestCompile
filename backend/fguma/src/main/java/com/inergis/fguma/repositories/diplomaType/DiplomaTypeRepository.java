package com.inergis.fguma.repositories.diplomaType;

import com.inergis.fguma.entities.DiplomaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomaTypeRepository extends JpaRepository<DiplomaType, Long> {

}