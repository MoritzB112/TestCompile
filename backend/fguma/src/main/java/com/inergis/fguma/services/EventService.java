package com.inergis.fguma.services;

import com.inergis.fguma.entities.Event;
import com.inergis.fguma.repositories.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAll(String name, Boolean includeDown) {
        if(includeDown){
            if (name != null) {
                return eventRepository.findByNameContaining(name);
            }
            return eventRepository.findAll();
        }
        if (name != null) {
            return eventRepository.findByNameContainingAndIsDown(name, includeDown);
        }
        return eventRepository.findByIsDown(includeDown);
    }

    public Event getById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public void delete(Event event) {
        eventRepository.delete(event);
    }

}