package com.inergis.fguma.services;

import com.inergis.fguma.entities.Schedule;
import com.inergis.fguma.repositories.schedule.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public Schedule getById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public List<Schedule> getByActivityId(Long id) {
        return scheduleRepository.findByActivityId(id);
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }

    public void delete(Schedule schedule) {
        scheduleRepository.delete(schedule);
    }

}