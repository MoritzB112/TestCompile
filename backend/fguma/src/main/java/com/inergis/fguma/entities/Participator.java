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
public class Participator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String identificationDocumentNumber;
    private String address;
    private String town;
    private Integer zip;
    private String phone;
    private String mobile;
    private String email;
    private String academicDegree;
    private String curriculum;
    @Temporal(TemporalType.DATE)
    private Date datesStart;
    private Boolean isCv;
    private String numberCCC;
    @Lob
    private String comments;
    private String position;
    private String country;
    private String swiff;
    private String iban;
    private String citizenship;
    private String dniFile;
    private String treatment;
    private Boolean acceptDataProtection;
    @Temporal(TemporalType.DATE)
    private Date dateAcceptDataProtection;
    private Boolean acceptPublicity;
    @Temporal(TemporalType.DATE)
    private Date dateAcceptPublicity;

    @OneToOne(mappedBy = "participator", fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private IdentificationDocument identificationDocument;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Gender gender;

    @OneToMany(mappedBy = "participator", fetch = FetchType.LAZY)
    private List<ParticipatorRole> participatorRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participator that = (Participator) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}