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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String identificationDocumentNumber;
    private Boolean identificationDocumentVerified;
    private String address;
    private String city;
    private Integer postalCode;
    private String province;
    private Integer phone;
    private Integer mobilePhone;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dateRegistration;
    private String passwordValidated;
    private Boolean isMinor;
    private String nameTutor;
    private String surnameTutor;
    private String identificationDocumentNumberTutor;
    private Boolean acceptDataProtection;
    @Temporal(TemporalType.DATE)
    private Date dateAcceptDataProtection;
    private Boolean acceptPublicity;
    @Temporal(TemporalType.DATE)
    private Date dateAcceptPublicity;
    private String professionOrStudies;
    private String howDidYouKnowUs;
    private String headquarters;
    private String repImage;

    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @ManyToOne(fetch = FetchType.LAZY)
    private EducationalLevel educationalLevel;
    @ManyToOne(fetch = FetchType.LAZY)
    private Title title;
    @ManyToOne(fetch = FetchType.LAZY)
    private University university;
    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;
    @ManyToOne(fetch = FetchType.LAZY)
    private Gender gender;
    @ManyToOne(fetch = FetchType.LAZY)
    private IdentificationDocument identificationDocument;
    @ManyToOne(fetch = FetchType.LAZY)
    private IdentificationDocument identificationDocumentTutor;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Registration> registrations;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Business> businesses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}