package com.inergis.fguma.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date day;
    @Temporal(TemporalType.TIME)
    private Date hourFrom;
    @Temporal(TemporalType.TIME)
    private Date hourTo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Classroom classroom;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LanguageLevel languageLevel;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Activity activity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule that = (Schedule) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}