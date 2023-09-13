package com.inergis.fguma.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Rate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    @Column(nullable = false)
    private Integer maxParticipants;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Activity activity;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Collective collective;

    @OneToMany(mappedBy = "rate", fetch = FetchType.LAZY)
    private List<Registration> registrations;

    @ManyToMany(mappedBy = "rates", fetch = FetchType.LAZY)
    private List<RequiredDocument> requiredDocuments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate that = (Rate) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}