package com.inergis.fguma.converters;

import com.inergis.fguma.entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityConverter {

    public static Activity toExternal(Activity entity) {
        if (entity == null) {
            return null;
        }

        return Activity.builder()
                .id(entity.getId())
                .name(entity.getName())
                .registrationJustFromPanel(entity.getRegistrationJustFromPanel())
                .dontSendNotification(entity.getDontSendNotification())
                .esBonus(entity.getEsBonus())
                .registerMinors(entity.getRegisterMinors())
                .notificationsMail(entity.getNotificationsMail())
                .showNotifications(entity.getShowNotifications())
                .codeTitleUMA(entity.getCodeTitleUMA())
                .codeFGUMA(entity.getCodeFGUMA())
                .idVirtualCampus(entity.getIdVirtualCampus())
                .virtualChannelCode(entity.getVirtualChannelCode())
                .delegationCode(entity.getDelegationCode())
                .projectCode(entity.getProjectCode())
                .dateStart(entity.getDateStart())
                .dateEnd(entity.getDateEnd())
                .minimumAssistance(entity.getMinimumAssistance())
                .registerUMADiploma(entity.getRegisterUMADiploma())
                .lengthHoursOnline(entity.getLengthHoursOnline())
                .lengthHoursOffline(entity.getLengthHoursOffline())
                .lengthHoursStreaming(entity.getLengthHoursStreaming())
                .dateStartInscription(entity.getDateStartInscription())
                .dateEndInscription(entity.getDateEndInscription())
                .expirationDays(entity.getExpirationDays())
                .numberCredits(entity.getNumberCredits())
                .observations(entity.getObservations())
                .description(entity.getDescription())
                .program(entity.getProgram())
                .numberInstallments(entity.getNumberInstallments())

                .event(toExternal(entity.getEvent()))
                .headquarter(toExternal(entity.getHeadquarter()))
                .ratingType(toExternal(entity.getRatingType()))
                .typeRegister(toExternal(entity.getTypeRegister()))
                .paymentAccount(toExternal(entity.getPaymentAccount()))
                .modality(toExternal(entity.getModality()))
                .diplomaType(toExternal(entity.getDiplomaType()))
                .billingType(toExternal(entity.getBillingType()))
                .language(toExternal(entity.getLanguage()))

                .schedules(entity.getSchedules().stream().map(ActivityConverter::toExternal).collect(Collectors.toList()))
                .rates(entity.getRates().stream().map(ActivityConverter::toExternal).collect(Collectors.toList()))
                .discounts(entity.getDiscounts().stream().map(ActivityConverter::toExternal).collect(Collectors.toList()))
                .participatorRoles(entity.getParticipatorRoles().stream().map(ActivityConverter::toExternal).collect(Collectors.toList()))
                .registrations(entity.getRegistrations().stream().map(ActivityConverter::toExternal).collect(Collectors.toList()))
                .attributesActivities(entity.getAttributesActivities().stream().map(ActivityConverter::toExternal).sorted(Comparator.comparing(o -> o.getAtribute().getViewOrder())).collect(Collectors.toList()))
                .languageLevels(entity.getLanguageLevels().stream().map(ActivityConverter::toExternal).collect(Collectors.toList()))

                .build();
    }

    public static Event toExternal(Event entity) {
        if (entity == null) {
            return null;
        }

        return Event.builder()
                .id(entity.getId())
                .name(entity.getName())

                .edition(toExternal(entity.getEdition()))

                .build();
    }

    public static Edition toExternal(Edition entity) {
        if (entity == null) {
            return null;
        }

        return Edition.builder()
                .id(entity.getId())
                .course(entity.getCourse())

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

    public static RatingType toExternal(RatingType entity) {
        if (entity == null) {
            return null;
        }

        return RatingType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static TypeRegister toExternal(TypeRegister entity) {
        if (entity == null) {
            return null;
        }

        return TypeRegister.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static PaymentAccount toExternal(PaymentAccount entity) {
        if (entity == null) {
            return null;
        }

        return PaymentAccount.builder()
                .id(entity.getId())
                .nominalName(entity.getNominalName())
                .build();
    }

    public static Modality toExternal(Modality entity) {
        if (entity == null) {
            return null;
        }

        return Modality.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static DiplomaType toExternal(DiplomaType entity) {
        if (entity == null) {
            return null;
        }

        return DiplomaType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static BillingType toExternal(BillingType entity) {
        if (entity == null) {
            return null;
        }

        return BillingType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Language toExternal(Language entity) {
        if (entity == null) {
            return null;
        }

        return Language.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Schedule toExternal(Schedule entity) {
        if (entity == null) {
            return null;
        }

        return Schedule.builder()
                .id(entity.getId())
                .day(entity.getDay())
                .hourFrom(entity.getHourFrom())
                .hourTo(entity.getHourTo())

                .classroom(toExternal(entity.getClassroom()))
                .languageLevel(toExternal(entity.getLanguageLevel()))

                .build();
    }

    public static Classroom toExternal(Classroom entity) {
        if (entity == null) {
            return null;
        }

        return Classroom.builder()
                .id(entity.getId())
                .classroom(entity.getClassroom())
                .build();
    }

    public static LanguageLevel toExternal(LanguageLevel entity) {
        if (entity == null) {
            return null;
        }

        return LanguageLevel.builder()
                .id(entity.getId())
                .level(entity.getLevel())
                .build();
    }

    public static Rate toExternal(Rate entity) {
        if (entity == null) {
            return null;
        }

        return Rate.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())

                .collective(toExternal(entity.getCollective()))

                .build();
    }

    public static Collective toExternal(Collective entity) {
        if (entity == null) {
            return null;
        }

        return Collective.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Discount toExternal(Discount entity) {
        if (entity == null) {
            return null;
        }

        return Discount.builder()
                .id(entity.getId())
                .reason(entity.getReason())
                .dateStart(entity.getDateStart())
                .dateEnd(entity.getDateEnd())
                .percentage(entity.getPercentage())
                .build();
    }

    public static ParticipatorRole toExternal(ParticipatorRole entity) {
        if (entity == null) {
            return null;
        }

        return ParticipatorRole.builder()
                .id(entity.getId())
                .hours(entity.getHours())

                .participator(toExternal(entity.getParticipator()))
                .role(toExternal(entity.getRole()))

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

                .user(toExternal(entity.getUser()))

                .build();
    }

    public static User toExternal(User entity) {
        if (entity == null) {
            return null;
        }

        return User.builder()
                .id(entity.getId())
                .dni(entity.getDni())
                .build();
    }

    public static Role toExternal(Role entity) {
        if (entity == null) {
            return null;
        }

        return Role.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Registration toExternal(Registration entity) {
        if (entity == null) {
            return null;
        }

        return Registration.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .solicitudeDate(entity.getSolicitudeDate())

                .student(toExternal(entity.getStudent()))

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

                .user(toExternal(entity.getUser()))

                .build();
    }

    public static AttributesActivity toExternal(AttributesActivity entity) {
        if (entity == null) {
            return null;
        }

        return AttributesActivity.builder()
                .id(entity.getId())
                .selected(entity.getSelected())

                .atribute(toExternal(entity.getAtribute()))

                .build();
    }

    public static Atribute toExternal(Atribute entity) {
        if (entity == null) {
            return null;
        }

        return Atribute.builder()
                .id(entity.getId())
                .fieldName(entity.getFieldName())
                .viewOrder(entity.getViewOrder())
                .build();
    }

    public static Activity toExternalForList(Activity entity) {
        if(entity == null) {
            return null;
        }

        return Activity.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateStart(entity.getDateStart())

                .modality(toExternalForList(entity.getModality()))
                .event(toExternalForList(entity.getEvent()))

                .build();
    }

    public static Modality toExternalForList(Modality entity) {
        if(entity == null) {
            return null;
        }

        return Modality.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Event toExternalForList(Event entity) {
        if(entity == null) {
            return null;
        }

        return Event.builder()
                .id(entity.getId())
                .name(entity.getName())

                .edition(toExternalForList(entity.getEdition()))

                .build();
    }

    public static Edition toExternalForList(Edition entity) {
        if(entity == null) {
            return null;
        }

        return Edition.builder()
                .id(entity.getId())
                .course(entity.getCourse())
                .build();
    }

}