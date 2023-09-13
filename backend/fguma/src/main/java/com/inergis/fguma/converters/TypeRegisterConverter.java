package com.inergis.fguma.converters;

import com.inergis.fguma.entities.TypeRegister;

public class TypeRegisterConverter {

    public static TypeRegister toExternal(TypeRegister entity) {
        if (entity == null) {
            return null;
        }

        return TypeRegister.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}