package com.inergis.fguma.repositories.activity;

import com.inergis.fguma.entities.Activity;
import com.inergis.fguma.searchEnums.ActivitySearch;

import java.util.Date;
import java.util.List;

public interface CustomActivityRepository {
    List<Activity> findWithFilters(String searchText, ActivitySearch search, Date start, Date end, Long editionId, Long eventId, Long modalityId, Long languageId);
}
