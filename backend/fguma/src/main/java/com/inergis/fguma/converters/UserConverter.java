package com.inergis.fguma.converters;

import com.inergis.fguma.entities.*;

public class UserConverter {

    public static User toExternal(User entity) {
        if (entity == null) {
            return null;
        }

        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())

                .appUser(toExternal(entity.getAppUser()))
                .participator(toExternal(entity.getParticipator()))
                .student(toExternal(entity.getStudent()))

                .build();
    }

    public static AppUser toExternal(AppUser entity) {
        if (entity == null) {
            return null;
        }

        return AppUser.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())

                .department(toExternal(entity.getDepartment()))

                .build();
    }

    public static Department toExternal(Department entity) {
        if (entity == null) {
            return null;
        }

        return Department.builder()
                .id(entity.getId())
                .name(entity.getName())
                .isCI(entity.getIsCI())
                .build();
    }

    public static Participator toExternal(Participator entity) {
        if (entity == null) {
            return null;
        }

        return Participator.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
    }

    public static Student toExternal(Student entity) {
        if (entity == null) {
            return null;
        }

        return Student.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
    }

}