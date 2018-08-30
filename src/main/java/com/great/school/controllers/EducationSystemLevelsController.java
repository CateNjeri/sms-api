package com.great.school.controllers;

import com.great.school.models.data.EducationSystemLevel;
import com.great.school.services.EducationSystemLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/education/systems")
@CrossOrigin
public class EducationSystemLevelsController {
    @Autowired
    EducationSystemLevelService educationSystemLevelService;

    @PostMapping("/levels")
    public ResponseEntity<EducationSystemLevel> add(@RequestBody @Valid EducationSystemLevel educationSystemLevel) {
        educationSystemLevelService.add(educationSystemLevel);
        return ResponseEntity.ok(educationSystemLevel);
    }

    @PutMapping("/levels/{id}")
    public ResponseEntity<EducationSystemLevel> update(@PathVariable long id, @RequestBody @Valid EducationSystemLevel educationSystemLevel) {
        return ResponseEntity.ok(educationSystemLevelService.update(educationSystemLevel));
    }

    @GetMapping("/levels/{id}")
    public ResponseEntity<EducationSystemLevel> find(@PathVariable long id) {
        return ResponseEntity.ok(educationSystemLevelService.getById(id));
    }

    @GetMapping("/levels")
    public ResponseEntity<List<EducationSystemLevel>> all() {
        return ResponseEntity.ok(educationSystemLevelService.all());
    }

    @GetMapping("/{educationSystemId}/levels")
    public ResponseEntity<List<EducationSystemLevel>> findByEducationSystem(@PathVariable long educationSystemId) {
        return ResponseEntity.ok(educationSystemLevelService.findByEducationSystemId(educationSystemId));
    }
}

