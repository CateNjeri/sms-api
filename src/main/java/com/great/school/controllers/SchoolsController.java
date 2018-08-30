package com.great.school.controllers;

import com.great.school.models.data.*;
import com.great.school.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */

@RestController
@RequestMapping("/schools")
@CrossOrigin
public class SchoolsController {
    @Autowired
    SchoolService schoolService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    ParentService parentService;

    @Autowired
    ClassLevelService classLevelService;

    @Autowired
    ClassLevelSectionService classLevelSectionService;

    @PostMapping
    public ResponseEntity<School> register(@Valid @RequestBody School school) {
        school = schoolService.add(school);
        return ResponseEntity.ok(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> all() {
        return ResponseEntity.ok(schoolService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> get(@PathVariable long id) {
        return ResponseEntity.ok(schoolService.getById(id));
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> students(@PathVariable long id) {
        return ResponseEntity.ok(studentService.findBySchoolId(id));
    }


    @GetMapping("/{id}/teachers")
    public ResponseEntity<List<Teacher>> teachers(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.findBySchoolId(id));
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<List<Subject>> subjects(@PathVariable long id) {
        return ResponseEntity.ok(subjectService.findBySchoolId(id));
    }

    @GetMapping("/{id}/parents")
    public ResponseEntity<List<Parent>> parents(@PathVariable long id) {
        return ResponseEntity.ok(parentService.findInSchool(id));
    }


    @GetMapping("/{id}/classes/levels")
    public ResponseEntity<List<ClassLevel>> classLevels(@PathVariable long id) {
        return ResponseEntity.ok(classLevelService.findBySchoolId(id));
    }

    @GetMapping("/{id}/classes/levels/sections")
    public ResponseEntity<List<ClassLevelSection>> classLevelSections(@PathVariable long id) {
        return ResponseEntity.ok(classLevelSectionService.findBySchoolId(id));
    }
}
