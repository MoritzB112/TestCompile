package com.inergis.fguma.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private Boolean registrationJustFromPanel;
    private Boolean dontSendNotification;
    private Boolean esBonus;
    private Boolean registerMinors;
    private String notificationsMail;
    private Boolean showNotifications;
    private String codeTitleUMA;
    private String codeFGUMA;
    private Long idVirtualCampus;
    private String virtualChannelCode;
    private String delegationCode;
    private String projectCode;
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    private Double minimumAssistance;
    private String registerUMADiploma;
    private Double lengthHoursOnline;
    private Double lengthHoursOffline;
    private Double lengthHoursStreaming;
    @Temporal(TemporalType.DATE)
    private Date dateStartInscription;
    @Temporal(TemporalType.DATE)
    private Date dateEndInscription;
    private Integer expirationDays;
    private Double numberCredits;
    @Lob
    private String observations;
    @Lob
    private String description;
    @Lob
    private String program;
    private Double numberInstallments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private Event event;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @ToString.Exclude
    private TypeRegister typeRegister;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @ToString.Exclude
    private Headquarter headquarter;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @ToString.Exclude
    private RatingType ratingType;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @ToString.Exclude
    private PaymentAccount paymentAccount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private Modality modality;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private DiplomaType diplomaType;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private BillingType billingType;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @ToString.Exclude
    private Language language;

    @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Rate> rates;
    @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Discount> discounts;
    @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ParticipatorRole> participatorRoles;
    @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Registration> registrations;
    @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AttributesActivity> attributesActivities;
    @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<LanguageLevel> languageLevels;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity that = (Activity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}