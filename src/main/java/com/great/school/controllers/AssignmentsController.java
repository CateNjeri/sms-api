package com.great.school.controllers;

import com.great.school.models.data.Assignment;
import com.great.school.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/assignments")
public class AssignmentsController {
    @Autowired
    AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<Assignment> create(@Valid @RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignmentService.add(assignment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> update(@PathVariable long id, @Valid @RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignmentService.update(assignment));
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> all() {
        return ResponseEntity.ok(assignmentService.all());
    }
}
