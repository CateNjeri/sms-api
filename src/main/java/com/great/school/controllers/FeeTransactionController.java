package com.great.school.controllers;

import com.great.school.models.data.FeeTransaction;
import com.great.school.services.FeeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/fees/transactions")
public class FeeTransactionController {

    @Autowired
    FeeTransactionService feeTransactionService;

    @PostMapping
    public ResponseEntity<FeeTransaction> create(@Valid @RequestBody FeeTransaction feeTransaction) {
        return ResponseEntity.ok(feeTransactionService.add(feeTransaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeeTransaction> update(@PathVariable long id, @Valid @RequestBody FeeTransaction feeTransaction) {
        return ResponseEntity.ok(feeTransactionService.add(feeTransaction));
    }

    @GetMapping
    public ResponseEntity<List<FeeTransaction>> all() {
        return ResponseEntity.ok(feeTransactionService.all());
    }
}
