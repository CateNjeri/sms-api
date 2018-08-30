package com.great.school.controllers;

import com.great.school.models.data.Subject;
import com.great.school.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@CrossOrigin
@RequestMapping("/subjects")
public class SubjectsController {

    @Autowired
    SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> create(@Valid @RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.add(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> update(@PathVariable long id, @Valid @RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.add(subject));
    }

    @GetMapping
    public ResponseEntity<List<Subject>> all() {
        return ResponseEntity.ok(subjectService.all());
    }
}
