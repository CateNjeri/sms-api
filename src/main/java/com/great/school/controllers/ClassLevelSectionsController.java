package com.great.school.controllers;

import com.great.school.models.data.ClassLevelSection;
import com.great.school.services.ClassLevelSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/classes/levels/sections")
@CrossOrigin
public class ClassLevelSectionsController {
    @Autowired
    ClassLevelSectionService classLevelSectionService;

    @PostMapping("")
    public ResponseEntity<ClassLevelSection> add(@RequestBody @Valid ClassLevelSection classLevelSection) {
        classLevelSectionService.add(classLevelSection);
        return ResponseEntity.ok(classLevelSection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassLevelSection> update(@PathVariable long id, @RequestBody @Valid ClassLevelSection classLevelSection) {
        return ResponseEntity.ok(classLevelSectionService.update(classLevelSection));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassLevelSection> find(@PathVariable long id) {
        return ResponseEntity.ok(classLevelSectionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClassLevelSection>> all() {
        return ResponseEntity.ok(classLevelSectionService.all());
    }
}

