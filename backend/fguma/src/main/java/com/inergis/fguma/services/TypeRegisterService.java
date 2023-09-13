package com.inergis.fguma.services;

import com.inergis.fguma.entities.TypeRegister;
import com.inergis.fguma.repositories.typeRegister.TypeRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeRegisterService {

    @Autowired
    private TypeRegisterRepository typeRegisterRepository;

    public List<TypeRegister> getAll() {
        return typeRegisterRepository.findAll();
    }

    public TypeRegister getById(Long id) {
        return typeRegisterRepository.findById(id).orElse(null);
    }

    public TypeRegister save(TypeRegister typeRegister) {
        return typeRegisterRepository.save(typeRegister);
    }

    public void deleteById(Long id) {
        typeRegisterRepository.deleteById(id);
    }

    public void delete(TypeRegister typeRegister) {
        typeRegisterRepository.delete(typeRegister);
    }

}