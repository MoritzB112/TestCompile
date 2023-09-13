package com.inergis.fguma.repositories.activity;

import com.inergis.fguma.entities.*;
import com.inergis.fguma.searchEnums.ActivitySearch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CustomActivityRepositoryImpl implements CustomActivityRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Activity> findWithFilters(String searchText, ActivitySearch search, Date start, Date end, Long editionId, Long eventId, Long modalityId, Long languageId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Activity> cq = cb.createQuery(Activity.class);

        Root<Activity> activity = cq.from(Activity.class);
        Join<Activity, Event> event = activity.join("event", JoinType.LEFT);
        Join<Event, Edition> edition = event.join("edition", JoinType.LEFT);
        Join<Activity, Modality> modality = activity.join("modality", JoinType.LEFT);
        Join<Activity, Language> language = activity.join("language", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (searchText != null && !searchText.isEmpty()) {
            switch (search) {
                case CURSO:
                    predicates.add(cb.like(activity.get("name"), "%" + searchText + "%"));
                    break;
                case CODIGOFGUMA:
                    predicates.add(cb.like(activity.get("codeFGUMA"), "%" + searchText + "%"));
                    break;
                case IDCAMOUSVIRTUAL:
                    predicates.add(cb.like(activity.get("idVirtualCampus"), "%" + searchText + "%"));
                    break;
            }
        }

        if (start != null) {
            predicates.add(cb.greaterThanOrEqualTo(activity.get("dateStart"), start));
        }

        if (end != null) {
            predicates.add(cb.lessThanOrEqualTo(activity.get("dateEnd"), end));
        }

        if (editionId != null) {
            predicates.add(cb.equal(edition.get("id"), editionId));
        }

        if (eventId != null) {
            predicates.add(cb.equal(event.get("id"), eventId));
        }

        if (modalityId != null) {
            predicates.add(cb.equal(modality.get("id"), modalityId));
        }

        if (languageId != null) {
            predicates.add(cb.equal(language.get("id"), languageId));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        cq.orderBy(cb.asc(activity.get("name")));

        return em.createQuery(cq).getResultList();
    }
}
