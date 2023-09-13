package com.inergis.fguma.converters;

import com.inergis.fguma.entities.DiplomaType;

public class DiplomaTypeConverter {

    public static DiplomaType toExternal(DiplomaType entity) {
        if (entity == null) {
            return null;
        }

        return DiplomaType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}