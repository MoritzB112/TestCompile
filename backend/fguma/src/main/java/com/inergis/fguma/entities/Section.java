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
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tag;
    private String tagE;
    private Boolean showEnglish;
    private Integer viewOrder;
    @Lob
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;
    @ManyToOne(fetch = FetchType.LAZY)
    private WebPage webPage;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    private List<Section> sections;
    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    private List<Edition> editions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section that = (Section) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}