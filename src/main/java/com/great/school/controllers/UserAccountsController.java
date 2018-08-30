package com.great.school.controllers;

import com.great.school.models.data.Parent;
import com.great.school.models.data.Student;
import com.great.school.models.data.UserAccount;
import com.great.school.services.ParentService;
import com.great.school.services.StudentService;
import com.great.school.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */

@RestController
@RequestMapping("/users/accounts")
@CrossOrigin
public class UserAccountsController {
    @Autowired
    UserAccountService userAccountService;

    @Autowired
    ParentService parentService;


    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<UserAccount> create(@Valid @RequestBody UserAccount userAccount) {
        userAccountService.add(userAccount);
        return ResponseEntity.ok(userAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        userAccountService.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<UserAccount>> all() {
        return ResponseEntity.ok(userAccountService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> get(@PathVariable long id) {
        return ResponseEntity.ok(userAccountService.getById(id));
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> parentUserAccountStudents(@PathVariable long id) {
        return ResponseEntity.ok(studentService.findByUserAccountId(id));
    }

    @GetMapping("/{id}/parents")
    public ResponseEntity<List<Parent>> parentUserAccounts(@PathVariable long id) {
        return ResponseEntity.ok(parentService.findByUserAccountId(id));
    }
}
