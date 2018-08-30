package com.great.school.controllers;

import com.great.school.models.data.Parent;
import com.great.school.models.data.Student;
import com.great.school.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 26-Nov-17.
 */
@RestController
@RequestMapping("/parents")
public class ParentsController {
    @Autowired
    ParentService parentService;

    @PostMapping
    public ResponseEntity<Parent> add(@RequestBody @Valid Parent parent) {
        return ResponseEntity.ok(parentService.add(parent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> update(@PathVariable long id, @RequestBody @Valid Parent parent) {
        return ResponseEntity.ok(parentService.update(parent));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Parent> get(@PathVariable long id) {
        return ResponseEntity.ok(parentService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Parent>> all() {
        return ResponseEntity.ok(parentService.all());
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> students(@PathVariable long id) {
        return ResponseEntity.ok(parentService.findStudents(id));
    }

}
