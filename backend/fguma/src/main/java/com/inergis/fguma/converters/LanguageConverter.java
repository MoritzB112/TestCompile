package com.inergis.fguma.converters;

import com.inergis.fguma.entities.Language;

public class LanguageConverter {

    public static Language toExternal(Language entity) {
        if (entity == null) {
            return null;
        }

        return Language.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}