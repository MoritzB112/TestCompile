package com.inergis.fguma.converters;

import com.inergis.fguma.entities.Classroom;
import com.inergis.fguma.entities.LanguageLevel;
import com.inergis.fguma.entities.Schedule;

public class ScheduleConverter {

    public static Schedule toExternalForLIst(Schedule entity) {
        if (entity == null) {
            return null;
        }

        return Schedule.builder()
                .id(entity.getId())
                .day(entity.getDay())
                .hourFrom(entity.getHourFrom())
                .hourTo(entity.getHourTo())

                .classroom(toExternalForLIst(entity.getClassroom()))
                .languageLevel(toExternalForLIst(entity.getLanguageLevel()))

                .build();
    }

    public static Classroom toExternalForLIst(Classroom entity) {
        if (entity == null) {
            return null;
        }

        return Classroom.builder()
                .id(entity.getId())
                .classroom(entity.getClassroom())
                .build();
    }

    public static LanguageLevel toExternalForLIst(LanguageLevel entity) {
        if (entity == null) {
            return null;
        }

        return LanguageLevel.builder()
                .id(entity.getId())
                .level(entity.getLevel())
                .build();
    }

}