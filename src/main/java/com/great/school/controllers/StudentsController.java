package com.great.school.controllers;

import com.great.school.models.data.FeeTransaction;
import com.great.school.models.data.Student;
import com.great.school.services.FeeTransactionService;
import com.great.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentsController {
    @Autowired
    StudentService studentService;


    @Autowired
    FeeTransactionService feeTransactionService;

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody @Valid Student student) {
        studentService.add(student);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable long id, @RequestBody @Valid Student student) {
        studentService.update(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> find(@PathVariable long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }


    @GetMapping("/{id}/fees/transactions")
    public ResponseEntity<List<FeeTransaction>> feeTransactions(@PathVariable long id) {
        return ResponseEntity.ok(feeTransactionService.studentFeeTransactions(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> all() {
        return ResponseEntity.ok(studentService.all());
    }
}

