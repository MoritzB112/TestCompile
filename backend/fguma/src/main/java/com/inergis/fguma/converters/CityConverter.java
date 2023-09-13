package com.inergis.fguma.converters;

import com.inergis.fguma.entities.City;
import com.inergis.fguma.entities.Headquarter;

public class CityConverter {

    public static City toExternal(City entity) {
        if (entity == null) {
            return null;
        }

        return City.builder()
                .id(entity.getId())
                .name(entity.getName())

                .headquarters(entity.getHeadquarters().stream().map(CityConverter::toExternal).toList())

                .build();
    }

    public static Headquarter toExternal(Headquarter entity) {
        if (entity == null) {
            return null;
        }

        return Headquarter.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}