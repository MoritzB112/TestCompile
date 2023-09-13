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
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean isCI;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Edition> editions;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Collective> collectives;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<PaymentAccount> paymentAccounts;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Modality> modalities;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<AppUser> appUsers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}