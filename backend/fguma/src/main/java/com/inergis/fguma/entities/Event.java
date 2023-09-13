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
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String normativeUrl;
    private Boolean isDown;
    private Boolean justOneRegistration;
    private Boolean showNeeds;
    private Boolean useVirtualCampus;
    private Boolean idWebinar;
    private Boolean paypal;
    private Boolean publish;
    private Boolean canMinors;
    private Boolean tpv;
    private String chanel;
    private String delegation;
    private String article;
    private String repImage;

    @ManyToOne(fetch = FetchType.LAZY)
    private Edition edition;
    @ManyToOne(fetch = FetchType.LAZY)
    private DiplomaType diplomaType;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<MailTemplate> mailTemplates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event that = (Event) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}