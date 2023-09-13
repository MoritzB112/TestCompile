package com.inergis.fguma.repositories.modality;

import com.inergis.fguma.entities.Modality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityRepository extends JpaRepository<Modality, Long> {

}