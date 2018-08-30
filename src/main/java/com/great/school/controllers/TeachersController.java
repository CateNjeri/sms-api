package com.great.school.controllers;

import com.great.school.models.data.Teacher;
import com.great.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/teachers")
@CrossOrigin
public class TeachersController {
    @Autowired
    TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> add(@RequestBody @Valid Teacher teacher) {
        teacherService.add(teacher);
        return ResponseEntity.ok(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable long id, @RequestBody @Valid Teacher teacher) {
        return ResponseEntity.ok(teacherService.update(teacher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> find(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> all() {
        return ResponseEntity.ok(teacherService.all());
    }
}

