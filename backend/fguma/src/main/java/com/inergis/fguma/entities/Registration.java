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
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long code;
    @Temporal(TemporalType.DATE)
    private Date solicitudeDate;

    private String cancellationReason;
    private Boolean scholarshipRequested;
    private Boolean scholarshipApproved;
    private Boolean scholarshipDenied;
    private Boolean acceptFilmAndPhoto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Activity activity;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Rate rate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Discount discount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private PaymentType paymentType;
    @ManyToOne(fetch = FetchType.LAZY)
    private Headquarter headquarter;
    @ManyToOne(fetch = FetchType.LAZY)
    private RegistrationState state;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}