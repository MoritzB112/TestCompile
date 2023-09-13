package com.inergis.fguma.repositories.activity;

import com.inergis.fguma.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>, CustomActivityRepository {
    List<Activity> findByNameContaining(String name);
}