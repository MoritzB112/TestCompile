package com.inergis.fguma.converters;

import com.inergis.fguma.entities.Event;

public class EventConverter {

    public static Event toExternalForList(Event entity) {
        if (entity == null) {
            return null;
        }

        return Event.builder()
                .id(entity.getId())
                .name(entity.getName())
                .publish(entity.getPublish())
                .isDown(entity.getIsDown())
                .idWebinar(entity.getIdWebinar())
                .build();
    }

}