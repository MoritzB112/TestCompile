package com.inergis.fguma.repositories.event;

import com.inergis.fguma.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContaining(String name);
    List<Event> findByNameContainingAndIsDown(String name, Boolean isDown);
    List<Event> findByIsDown(Boolean isDown);
}