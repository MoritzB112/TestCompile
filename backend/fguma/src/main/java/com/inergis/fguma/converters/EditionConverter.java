package com.inergis.fguma.converters;

import com.inergis.fguma.entities.Edition;

public class EditionConverter {

    public static Edition toExternalForList(Edition entity) {
        if (entity == null) {
            return null;
        }

        return Edition.builder()
                .id(entity.getId())
                .course(entity.getCourse())
                .build();
    }

}