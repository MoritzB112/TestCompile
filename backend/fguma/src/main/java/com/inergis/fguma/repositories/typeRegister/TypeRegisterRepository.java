package com.inergis.fguma.repositories.typeRegister;

import com.inergis.fguma.entities.TypeRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRegisterRepository extends JpaRepository<TypeRegister, Long> {

}