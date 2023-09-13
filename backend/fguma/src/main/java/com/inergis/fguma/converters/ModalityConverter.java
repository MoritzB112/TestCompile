package com.inergis.fguma.converters;

import com.inergis.fguma.entities.Modality;

public class ModalityConverter {

    public static Modality toExternal(Modality entity) {
        if (entity == null) {
            return null;
        }

        return Modality.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}