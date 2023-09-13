package com.inergis.fguma.repositories.languageLevel;

import com.inergis.fguma.entities.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageLevelRepository extends JpaRepository<LanguageLevel, Long> {

    List<LanguageLevel> findByActivityId(Long id);
}