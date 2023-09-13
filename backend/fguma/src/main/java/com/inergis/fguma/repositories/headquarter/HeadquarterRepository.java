package com.inergis.fguma.repositories.headquarter;

import com.inergis.fguma.entities.Headquarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadquarterRepository extends JpaRepository<Headquarter, Long> {

}