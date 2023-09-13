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
public class WebPage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tag;
    private String tagE;
    @Lob
    private String description;
    @Lob
    private String descriptionE;
    private Boolean incluedeSearch;
    private Boolean needLogin;
    @Temporal(TemporalType.DATE)
    private Date madificationDate;
    private Boolean isSecretaty;
    private Integer idSchema;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comission comission;
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @OneToMany(mappedBy = "webPage", fetch = FetchType.LAZY)
    private List<Section> sections;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage that = (WebPage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}