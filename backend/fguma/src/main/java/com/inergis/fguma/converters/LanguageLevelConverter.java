package com.inergis.fguma.converters;

import com.inergis.fguma.entities.LanguageLevel;

public class LanguageLevelConverter {

    public static LanguageLevel toExternal(LanguageLevel entity) {
        if (entity == null) {
            return null;
        }

        return LanguageLevel.builder()
                .id(entity.getId())
                .level(entity.getLevel())
                .build();
    }

}