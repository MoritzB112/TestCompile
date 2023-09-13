package com.inergis.fguma.converters;

import com.inergis.fguma.entities.RatingType;

public class RatingTypeConverter {

    public static RatingType toExternal(RatingType entity) {
        if (entity == null) {
            return null;
        }

        return RatingType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}