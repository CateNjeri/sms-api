package com.great.school.controllers;

import com.great.school.models.data.EducationSystem;
import com.great.school.services.EducationSystemService;
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
public class EducationSystemsController {
    @Autowired
    EducationSystemService educationSystemService;

    @PostMapping
    public ResponseEntity<EducationSystem> add(@RequestBody @Valid EducationSystem educationSystem) {
        educationSystemService.add(educationSystem);
        return ResponseEntity.ok(educationSystem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationSystem> update(@PathVariable long id, @RequestBody @Valid EducationSystem educationSystem) {
        return ResponseEntity.ok(educationSystemService.update(educationSystem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationSystem> find(@PathVariable long id) {
        return ResponseEntity.ok(educationSystemService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EducationSystem>> all() {
        return ResponseEntity.ok(educationSystemService.all());
    }
}

