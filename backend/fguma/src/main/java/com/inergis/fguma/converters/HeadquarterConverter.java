package com.inergis.fguma.converters;

import com.inergis.fguma.entities.City;
import com.inergis.fguma.entities.Headquarter;

public class HeadquarterConverter {

    public static Headquarter toExternal(Headquarter entity) {
        if (entity == null) {
            return null;
        }

        return Headquarter.builder()
                .id(entity.getId())
                .name(entity.getName())

                .city(toExternal(entity.getCity()))

                .build();
    }

    public static City toExternal(City entity) {
        if (entity == null) {
            return null;
        }

        return City.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}