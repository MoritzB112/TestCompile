package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.Activity;
import com.inergis.fguma.converters.ActivityConverter;
import com.inergis.fguma.entities.User;
import com.inergis.fguma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.ActivityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Activity>> getAll(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestParam(required = false) String searchText,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) Long edition,
            @RequestParam(required = false) Long event,
            @RequestParam(required = false) Long modality,
            @RequestParam(required = false) Long language) {
        User user = userService.getByToken(token);
        Date start = null;
        try {
                start = sdf.parse(startDate);
        } catch (Exception e) {
            startDate = null;
        }
        Date end = null;
        try {
            end = sdf.parse(endDate);
        } catch (Exception e) {
            endDate = null;
        }
        return ResponseEntity.ok(activityService.getWithFilters(searchText, search, start, end, edition, event, modality, language).stream().filter(activity -> {
            if (user == null) {
                return false;
            }
            if (user.getAppUser() == null) {
                return false;
            }
            return activity.getEvent().getEdition().getDepartment().getId().equals(user.getAppUser().getDepartment().getId());
        }).map(ActivityConverter::toExternal).toList());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Activity> getById(@PathVariable("id") Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        Activity activity = activityService.getById(id);
        if (activity == null) {
            return ResponseEntity.notFound().build();
        }
        User user = userService.getByToken(token);
        if (user == null || !user.getAppUser().getDepartment().getId().equals(activity.getEvent().getEdition().getDepartment().getId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(ActivityConverter.toExternal(activity));
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<Activity> create(@RequestBody Activity activity) {
        if (activity.getId() != null && activityService.getById(activity.getId()) != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(null).body(ActivityConverter.toExternal(activityService.save(activity)));
    }

    @PutMapping(value = "", produces = "application/json")
    public ResponseEntity<Activity> update(@RequestBody Activity activity) {
        if (activity.getId() == null || activityService.getById(activity.getId()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ActivityConverter.toExternal(activityService.update(activity)));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Activity> delete(@PathVariable("id") Long id) {
        Activity activity = activityService.getById(id);
        if (activity == null) {
            return ResponseEntity.notFound().build();
        }
        activityService.delete(activity);
        return ResponseEntity.ok().build();
    }

}