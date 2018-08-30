package com.great.school.controllers;

import com.great.school.models.data.ClassLevel;
import com.great.school.services.ClassLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/classes/levels")
@CrossOrigin
public class ClassLevelsController {
    @Autowired
    ClassLevelService classLevelService;

    @PostMapping
    public ResponseEntity<ClassLevel> add(@RequestBody @Valid ClassLevel classLevel) {
        return ResponseEntity.ok(classLevelService.add(classLevel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassLevel> update(@PathVariable long id, @RequestBody @Valid ClassLevel classLevel) {
        return ResponseEntity.ok(classLevelService.update(classLevel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassLevel> find(@PathVariable long id) {
        return ResponseEntity.ok(classLevelService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClassLevel>> all() {
        return ResponseEntity.ok(classLevelService.all());
    }
}

