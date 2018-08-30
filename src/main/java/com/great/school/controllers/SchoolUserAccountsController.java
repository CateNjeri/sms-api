package com.great.school.controllers;

import com.great.school.models.data.SchoolUserAccount;
import com.great.school.services.SchoolUserAccountService;
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
public class SchoolUserAccountsController {
    @Autowired
    SchoolUserAccountService schoolUserAccountService;

    @PostMapping("/users/accounts")
    public ResponseEntity<SchoolUserAccount> create(@Valid @RequestBody SchoolUserAccount schoolUserAccount) {
        schoolUserAccountService.add(schoolUserAccount);
        return ResponseEntity.ok(schoolUserAccount);
    }

    @DeleteMapping("/users/accounts/{id}")
    public ResponseEntity delete(@PathVariable long schoolId, @PathVariable long id) {
        schoolUserAccountService.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/users/accounts")
    public ResponseEntity<List<SchoolUserAccount>> all() {
        return ResponseEntity.ok(schoolUserAccountService.all());
    }

    @GetMapping("/{schoolId}/users/accounts")
    public ResponseEntity<List<SchoolUserAccount>> userAccountsBySchoolId(@PathVariable long schoolId) {
        return ResponseEntity.ok(schoolUserAccountService.findBySchoolId(schoolId));
    }

    @GetMapping("/users/accounts{id}")
    public ResponseEntity<SchoolUserAccount> get(@PathVariable long id) {
        return ResponseEntity.ok(schoolUserAccountService.getById(id));
    }
}
