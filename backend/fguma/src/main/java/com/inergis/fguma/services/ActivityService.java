package com.inergis.fguma.services;

import com.inergis.fguma.entities.Activity;
import com.inergis.fguma.repositories.activity.ActivityRepository;
import com.inergis.fguma.searchEnums.ActivitySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private LanguageLevelService languageLevelService;

    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    public List<Activity> getWithFilters(String searchText, String search, Date startDate, Date endDate, Long editionId, Long eventId, Long modalityId, Long languageId) {
        return activityRepository.findWithFilters(searchText, ActivitySearch.fromString(search), startDate, endDate, editionId, eventId, modalityId, languageId);
    }

    public Activity getById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    public Activity save(Activity activity) {
        activity.setLanguage(languageService.getById(activity.getLanguage().getId()));
        activity.getLanguageLevels().forEach(languageLevel -> {
            languageLevel.setActivity(activity);
            languageLevelService.save(languageLevel);
        });
        return activityRepository.save(activity);
    }

    public Activity update(Activity activity) {
        Activity original = activityRepository.findById(activity.getId()).orElse(null);

        if (original != null && original.getLanguageLevels() != null) {
            original.getLanguageLevels().forEach(languageLevel -> {
                languageLevelService.delete(languageLevel);

            });
        }

        activity.getLanguageLevels().forEach(languageLevel -> {
            languageLevel.setActivity(activity);
            languageLevelService.save(languageLevel);
        });

        activity.setLanguage(languageService.getById(activity.getLanguage().getId()));
        return activityRepository.save(activity);
    }

    public void deleteById(Long id) {
        activityRepository.deleteById(id);
    }

    public void delete(Activity activity) {
        activityRepository.delete(activity);
    }

}